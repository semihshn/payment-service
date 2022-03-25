package com.semihshn.paymentservice.domain.payment;

import com.semihshn.paymentservice.adapter.jpa.payment.CardType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Payment {

    private Long id;
    private Long userId;
    private String cvv;
    private String expireDate;

    @Enumerated(EnumType.STRING)
    private CardType cardType;
    private String ccNo;
    private BigInteger amount;
}
