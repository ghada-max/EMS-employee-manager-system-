package com.ghada.payrollProject.payroll.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class paymentevent implements Serializable {

    private Integer employeeId;
    private String bankAccount;
    private Double amount;
    private String name;
    private String email;
    private Integer contact;
}
