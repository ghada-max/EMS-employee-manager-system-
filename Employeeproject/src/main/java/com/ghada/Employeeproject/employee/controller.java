package com.ghada.Employeeproject.employee;
import com.ghada.Employeeproject.employee.service;

import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Ems")
public class controller {
    public final service serv;

    public controller(service serv) {
        this.serv = serv;
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody employee empl) {

            String Response=serv.createEmployee(empl);
            return new ResponseEntity<>(Response,HttpStatus.OK);

    }

    @PostMapping("/updateEmployee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @Valid @RequestBody employee empl) {

       String Response=serv.updateEmployee(id,empl);
        return new ResponseEntity<>(Response,HttpStatus.OK);

    }

    @PostMapping("/updateEmployeeLeaveBalance/{id}")
    public ResponseEntity<String> updateEmployeeLeaveBalance(@PathVariable Integer id) {

        String Response=serv.updateEmployeeLeaveBalance(id);
        return new ResponseEntity<>(Response,HttpStatus.OK);

    }

    @PostMapping("/updateEmployeeAbsentHours/{id}")
    public ResponseEntity<String> updateEmployeeAbsentHours(@PathVariable Integer id,@RequestParam Integer absentHours) {

        String Response=serv.updateEmployeeAbsentHours(id,absentHours);
        return new ResponseEntity<>(Response,HttpStatus.OK);

    }

    @PostMapping("/updateEmployeeLeaveDeduction/{id}")
    public ResponseEntity<String> updateEmployeeLeaveDeduction(@PathVariable Integer id, @RequestParam Double leaveded) {

        String Response=serv.updateEmployeeDeduction(id,leaveded);
        return new ResponseEntity<>(Response,HttpStatus.OK);

    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<employee>> getAllEmployee() {
       List<employee> Response=serv.getAllEmployee();
        return new  ResponseEntity<>(Response,HttpStatus.OK);

    }


    @GetMapping("/getEmployeById/{id}")
    public ResponseEntity<employee> getEmployeById(@PathVariable Integer id) {
        employee Response=serv.getEmployeById(id);
        return new  ResponseEntity<>(Response,HttpStatus.OK);

    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        String Response=serv.deleteEmployee(id);
        return new  ResponseEntity<>(Response,HttpStatus.OK);

    }



}
