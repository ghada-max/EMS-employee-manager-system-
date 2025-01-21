package com.ghada.attendanceproject.attendance.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "employeemicrosrvice", url = "http://localhost:8673/api/Ems") // Change the URL based on your Leave module's service URL
public interface attendanceClient {
    @PostMapping("/updateEmployeeAbsentHours/{id}")
    String updateEmployeeAbsentHours(@PathVariable("id") Integer id, @RequestParam Integer absentHours);



}
