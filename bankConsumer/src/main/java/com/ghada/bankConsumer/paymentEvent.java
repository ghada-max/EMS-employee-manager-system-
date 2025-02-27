package com.ghada.bankConsumer;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class paymentEvent  {

    private Integer employeeId;
    private String bankAccount;
    private Double amount;
    private String name;
    private String email;
    private Integer contact;
}