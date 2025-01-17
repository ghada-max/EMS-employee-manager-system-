package com.ghada.Employeeproject.employee;



import com.ghada.payrollProject.payroll.enums.PaymentStatus;
import com.ghada.payrollProject.payroll.enums.PaymentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Data
@Builder
@Table(name="payroll")
public class payroll {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer employeeid;
    private Double salary;
    private Double leavededuction;
    private Double AttendanceDEduction;
    private Double salaryAfterwork;
    @Enumerated
    private PaymentStatus paymentstat;
    @Enumerated
    private PaymentType paymenttype;
    //@NotEmpty(message = "name field is empty")
    //@Pattern(regexp = "^[A-Za-z]+$", message = "Contact name must contain only letters (A-Z, a-z).")




}