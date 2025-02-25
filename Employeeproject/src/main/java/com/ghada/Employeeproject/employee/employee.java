package com.ghada.Employeeproject.employee;



import com.ghada.Employeeproject.employee.enums.PaymentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serializable;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Data
@Builder
@Table(name="employee")
public class employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer categoryid;
    @NotEmpty(message = "name field is empty")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Contact name must contain only letters (A-Z, a-z).")
    private String name;
    private Integer departmentid;
    @Email(message = "email format is not valid")
    @NotEmpty(message = "email field is empty")
    @Column(unique = true)
    private String email;
    // @NotEmpty(message = "contact field is empty")
    @NotNull(message="empty data!")
    // @Pattern(regexp = "^[0-9]+$", message = "Contact name must contain only numbers.")
    private Integer contact;
    private Integer leavebalance;  // Enu
    private Double  salary;  // Enu

    private Double  leavededuction;  // Enu
    private Integer  AbsentHours;
    private Double AttendanceDeduction;
    //@Enumerated(EnumType.STRING)
    //private PaymentType paymenttype;

    //  private Double rate;



}