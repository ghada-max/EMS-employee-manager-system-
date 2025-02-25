package com.ghada.Employeeproject.employee.communication;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Data
@Builder
public class department {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    @Enumerated
    private category category;
    private Double salary;


}
