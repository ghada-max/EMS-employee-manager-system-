package com.ghada.bankConsumer.objects;

import com.ghada.bankConsumer.enums.BankPaymentResult;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class paymentResult implements Serializable {
    private Integer id;
    private BankPaymentResult BankPaymentResult;
    private Double ammount;
}
