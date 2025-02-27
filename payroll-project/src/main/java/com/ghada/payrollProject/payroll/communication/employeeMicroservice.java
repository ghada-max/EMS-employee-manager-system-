package com.ghada.payrollProject.payroll.communication;

import com.ghada.payrollProject.payroll.employeeDto.employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name="employeemicrosrvice",url="http://localhost:8673/api/Ems")
public interface employeeMicroservice {
    @GetMapping("/getEmployeById/{id}")
    Optional<employee> getEmployeeById(@PathVariable Integer id);
    //GetDepartmentById
 
}
