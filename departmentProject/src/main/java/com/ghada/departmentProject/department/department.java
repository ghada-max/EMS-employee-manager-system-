package com.ghada.departmentProject.department;



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
@Table(name="department_tab")
public class department {
    //deductionPerEmployeePerMonth
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    @Enumerated
    private category category;
    private Double salary;


}
