package com.ghada.payrollProject.payroll.employeeDto;



import com.ghada.payrollProject.payroll.enums.PaymentStatus;
import com.ghada.payrollProject.payroll.enums.PaymentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class employee {
    private Integer id;
    private Integer categoryid;
    private String name;
    private Integer departmentid;
    private String email;
    private Integer contact;
    private Integer leavebalance;
    private Double leavededuction;
    private Integer absentHours;
    private Double salary;
    private String bankcoordinates;
// + getter and setter

    private Double attendanceDeduction;
   // @Enumerated(EnumType.STRING)
    //private PaymentType paymenttype;

}
