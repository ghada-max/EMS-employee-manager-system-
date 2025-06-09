package com.ghada.deduction.deduction.communiciation;

import com.ghada.deduction.deduction.employee.employeeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "employeemicroservice", url = "http://localhost:8673/api/Ems") // Change the URL based on your Leave module's service URL
public interface  deductionClient {

    @GetMapping("/getAllEmployee")
    List<employeeResponse> getAllEmployee();

    @PostMapping("/updateEmployeeLeaveDeduction/{id}")
    String updateEmployeeLeaveDeduction(@PathVariable("id") Integer id,@RequestParam Double leaveded);


}
