package com.ghada.Employeeproject.employee;



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
@Table(name="employee")
public class employee {

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
    private Double leavededuction;  // Enu


    //  private Double rate;



}