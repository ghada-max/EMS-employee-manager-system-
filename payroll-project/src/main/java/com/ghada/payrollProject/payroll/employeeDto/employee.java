package com.ghada.payrollProject.payroll.employeeDto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class employeeDto {
    private Integer id;
    private Integer categoryid;
    private String name;
    private Integer departmentid;
    private String email;
    private Integer contact;
    private Integer leavebalance;
    private Double leavededuction;
    private Integer absentHours;
    private Double attendanceDeduction;
}
