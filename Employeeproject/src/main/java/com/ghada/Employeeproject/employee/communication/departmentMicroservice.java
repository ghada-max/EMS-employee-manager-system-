package com.ghada.Employeeproject.employee.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name="departmentmicroservice",url="http://localhost:8764/api/Ems/Department")
public interface departmentMicroservice {
    @GetMapping("/getAllDepartments")
    List<department> getAllDepartments();
    //GetDepartmentById
    @GetMapping("/GetDepartmentById/{departmentId}")
    Optional<department> GetDepartmentById(@PathVariable("departmentId") Integer departmentId);
}
