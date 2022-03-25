package com.semihshn.paymentservice.adapter.rest.payment.response;

import com.semihshn.paymentservice.adapter.jpa.payment.CardType;
import com.semihshn.paymentservice.domain.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private Long id;
    private Long userId;
    private String cvv;
    private String expireDate;

    @Enumerated(EnumType.STRING)
    private CardType cardType;
    private String ccNo;
    private BigInteger amount;

    public static PaymentResponse from(Payment payment) {
        return PaymentResponse.builder()
                .id(payment.getId())
                .userId(payment.getUserId())
                .cvv(payment.getCvv())
                .expireDate(payment.getExpireDate())
                .cardType(payment.getCardType())
                .ccNo(payment.getCcNo())
                .amount(payment.getAmount())
                .build();
    }
}
