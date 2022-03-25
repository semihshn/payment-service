package com.semihshn.paymentservice.adapter.rest.payment.request;

import com.semihshn.paymentservice.adapter.jpa.payment.CardType;
import com.semihshn.paymentservice.domain.payment.Payment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
public class PaymentCreateRequest {

    @NotNull
    private Long userId;

    @NotBlank
    private String cvv;

    @NotBlank
    private String expireDate;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @NotBlank
    private String ccNo;

    @NotNull
    private BigInteger amount;


    public Payment convertToPayment() {
        return Payment.builder()
                .userId(userId)
                .cvv(cvv)
                .expireDate(expireDate)
                .cardType(cardType)
                .ccNo(ccNo)
                .amount(amount)
                .build();
    }
}
