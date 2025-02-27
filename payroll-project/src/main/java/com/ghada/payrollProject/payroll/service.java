package com.ghada.payrollProject.payroll;

import com.ghada.payrollProject.payroll.communication.employeeMicroservice;
import com.ghada.payrollProject.payroll.dto.paymentevent;
import com.ghada.payrollProject.payroll.employeeDto.employee;
import com.ghada.payrollProject.payroll.enums.PaymentType;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static com.ghada.payrollProject.payroll.enums.PaymentType.BankTransfer;

@Service
public class service {
    @Autowired
    Repository repo;

    @Autowired
    private KafkaTemplate<String, paymentevent> kafkaTemplate;

    @Autowired
    private employeeMicroservice employeeMicro;
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
                .paymenttype(BankTransfer.getLabel())
                //.paymenttype(message.getPaymenttype())
        .build();

        repo.save(payroll);
        System.out.println(message);

        return payroll;

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


    public  List<paymentevent> createPayment() {
        //bank transfer
     List<Payroll> payrolls=repo.findByPaymenttype(BankTransfer.getLabel());

        if (payrolls.isEmpty()) {
            System.out.println("No payroll records found for Bank Transfer.");
            return new ArrayList<>();
        }
    // List<Optional<employee>> employees=new ArrayList<>();
        List<paymentevent> paymentevents=new ArrayList<>();

        payrolls.stream().forEach(payroll -> {
            employee empl= null;
            try {
                empl = employeeMicro.getEmployeeById(payroll.getEmployeeid())
                        .orElseThrow(() -> new Exception("Employee not found"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            //on va   le transferer


                paymentevent event = paymentevent.builder()
                        .employeeId(empl.getId())
                        .amount(payroll.getSalaryAfterwork())
                        .name(empl.getName())
                        .email(empl.getEmail())
                        .contact(empl.getContact())
                        .build();

                paymentevents.add(event);
            String topic="paymentevent_transaction";

            kafkaTemplate.send(topic,event);

     });
        return paymentevents;
}




}
