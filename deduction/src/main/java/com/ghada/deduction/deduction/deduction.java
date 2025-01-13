package com.ghada.deduction.deduction;


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
@Table(name="deduction")
public class deduction {
//deductionPerEmployeePerMonth
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer emloyeeid;
    private Date Ammount;



}
