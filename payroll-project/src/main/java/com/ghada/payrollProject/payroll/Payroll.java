package com.ghada.payrollProject.payroll;



import com.ghada.payrollProject.payroll.enums.PaymentStatus;
import com.ghada.payrollProject.payroll.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Data
@Builder
@Table(name="payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer employeeid;
    private String employeename;

    private Double salary;
    private Double leavededuction;
    private Double AttendanceDEduction;
    private Double salaryAfterwork;
    @Enumerated
    private PaymentStatus paymentstatus;


    private String paymenttype;
    //@NotEmpty(message = "name field is empty")
    //@Pattern(regexp = "^[A-Za-z]+$", message = "Contact name must contain only letters (A-Z, a-z).")




}