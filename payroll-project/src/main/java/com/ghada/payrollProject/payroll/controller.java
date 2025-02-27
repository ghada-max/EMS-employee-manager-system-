package com.ghada.payrollProject.payroll;

import com.ghada.payrollProject.payroll.dto.paymentevent;
import com.ghada.payrollProject.payroll.employeeDto.employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Ems/payroll")
public class controller {
     public final service serv;

    public controller(service serv) {
        this.serv = serv;
    }


   // private ResponseEntity<String> createPayment(@RequestBody Payroll payroll){
        //String Response=serv.createPayment(payroll);
    //    return new ResponseEntity<>(Response,HttpStatus.OK);


   // }

    @GetMapping("/GetSalaryAfterWork")
    private Void GetSalaryAfterWork(){
        return serv.calculateSalary();
    }


    @GetMapping("/getemployeeswithbanktransfer")
    private List<paymentevent> createPayment(){
        return serv.createPayment();
    }





}
