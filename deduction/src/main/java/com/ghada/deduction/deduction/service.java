package com.ghada.deduction.deduction;

import com.ghada.deduction.deduction.communiciation.deductionClient;
import com.ghada.deduction.deduction.employee.employeeResponse;
import com.ghada.deduction.deduction.employee.leaveDeduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class service {
    @Autowired
    deductionClient deductionclient;

    public List<leaveDeduction> createLeaveDeduction() {
        try {
            List<employeeResponse> list = deductionclient.getAllEmployee()
                    .stream()
                    .map(employeeResponse -> {
                        employeeResponse employee = new employeeResponse();
                        employee.setId(employeeResponse.getId());
                        employee.setLeavebalance(employeeResponse.getLeavebalance());
                        return employee;
                    })
                    .collect(Collectors.toList());
            List<leaveDeduction> leaveDedList=new ArrayList<>();
            leaveDedList = list.stream()
                    .map(employeeResponse -> {
                        leaveDeduction leaveDed = new leaveDeduction();
                        leaveDed.setId(employeeResponse.getId());
                        leaveDed.setLeavededuction((double) (employeeResponse.getLeavebalance() * 40));
                        return leaveDed;  
                    })
                    .collect(Collectors.toList());
            leaveDedList.forEach(lv -> {
                deductionclient.updateEmployeeLeaveDeduction(lv.getId(),lv.getLeavededuction());

            });

            return leaveDedList;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching employee data", e);
        }
    }

}
