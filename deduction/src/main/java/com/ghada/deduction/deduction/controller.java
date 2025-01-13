package com.ghada.deduction.deduction;

import com.ghada.deduction.deduction.employee.employeeResponse;
import com.ghada.deduction.deduction.employee.leaveDeduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/Ems/deduction")
public class controller {
     @Autowired
     service serv;
    @GetMapping("/createLeaveDeduction")
    public List<leaveDeduction> createLeaveDeduction(){
        List<leaveDeduction> Response=serv.createLeaveDeduction();
        return Response;
    }
}
