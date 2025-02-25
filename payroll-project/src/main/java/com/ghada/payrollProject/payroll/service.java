package com.ghada.payrollProject.payroll;

import com.ghada.payrollProject.payroll.employeeDto.employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class service {
    @Autowired
    Repository repo;
    private ConcurrentHashMap<Integer, Integer> employeeCache = new ConcurrentHashMap<>();

    @Transactional
    @KafkaListener(topics="create-employee",groupId="payroll-group")
    public Payroll handleNewEmployee(employee message){
       // employee employeeDto = new employee();

        Payroll payroll = Payroll.builder().employeeid(message.getId())
                .employeename(message.getName())
                .salary(message.getSalary())
                .AttendanceDEduction(0.0)
                .leavededuction(0.0)
                //.paymenttype(message.getPaymenttype())
        .build();

        repo.save(payroll);
        System.out.println(message);

        return  payroll;

    }

    @Transactional
    @KafkaListener(topics="updateEmplyeeDeduction",groupId="payroll-group")
    public Payroll handleUpdateEmplyeeDeduction(employee message){
        // employee employeeDto = new employee();
      Payroll pay=  repo.findByEmployeeid(message.getId()).map(foundedPayroll -> {
            foundedPayroll.setLeavededuction(message.getLeavededuction());
            return repo.save(foundedPayroll);
            //System.out.println(message);

       }).orElseThrow(() -> new EntityNotFoundException("payrollNotFound"));
       return pay;
         //return message;


    }
    //String topic="";
    @Transactional
    @KafkaListener(topics="updateEmplyeeAttendanceDeduction",groupId="payroll-group")
    public Payroll updateEmplyeeAttendanceDeduction(employee message){
        // employee employeeDto = new employee();
        Payroll pay=  repo.findByEmployeeid(message.getId()).map(foundedPayroll -> {
            foundedPayroll.setAttendanceDEduction(message.getAttendanceDeduction());
            return repo.save(foundedPayroll);
            //System.out.println(message);

        }).orElseThrow(() -> new EntityNotFoundException("payrollNotFound"));
        return pay;
        //return message;


    }

    public Void calculateSalary() {
        List<Payroll> payrolls=repo.findAll();
      payrolls.stream().forEach(payroll -> {
           Double TotalDeduction= payroll.getLeavededuction()+ payroll.getAttendanceDEduction();
           payroll.setSalaryAfterwork(payroll.getSalary()-TotalDeduction);
       });
      repo.saveAll(payrolls);
      return null;
    }


    public String createPayment(Payroll payroll) {
        return "h";
    }



}
