package com.ghada.bankConsumer.objects;

import lombok.*;

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