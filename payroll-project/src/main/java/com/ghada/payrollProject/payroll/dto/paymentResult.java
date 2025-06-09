package com.ghada.payrollProject.payroll.dto;

import com.ghada.payrollProject.payroll.enums.BankPaymentResult;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class paymentResult  {
    private Integer id;
    private BankPaymentResult BankPaymentResult;
    private Double ammount;
}
