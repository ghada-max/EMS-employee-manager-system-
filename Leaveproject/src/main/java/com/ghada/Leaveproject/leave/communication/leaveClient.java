package com.ghada.Leaveproject.leave.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "employeemicrosrvice", url = "http://localhost:8673/api/Ems") // Change the URL based on your Leave module's service URL
public interface  leaveClient {

    @PostMapping("/updateEmployeeLeaveBalance/{id}")
    String updateEmployeeLeaveBalance(@PathVariable("id") Integer id);


}
