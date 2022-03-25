package com.semihshn.paymentservice.adapter.jpa.payment;

import com.semihshn.paymentservice.adapter.jpa.common.BaseEntity;
import com.semihshn.paymentservice.adapter.jpa.common.Status;
import com.semihshn.paymentservice.domain.payment.Payment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "payments")
@Table(name = "payments")
public class PaymentEntity extends BaseEntity {

    private Long userId;
    private String cvv;
    private String expireDate;

    @Enumerated(EnumType.STRING)
    private CardType cardType;
    private String ccNo;
    private BigInteger amount;

    public static PaymentEntity from(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.id = payment.getId();
        paymentEntity.userId=payment.getUserId();
        paymentEntity.cvv=payment.getCvv();
        paymentEntity.expireDate=payment.getExpireDate();
        paymentEntity.cardType=payment.getCardType();
        paymentEntity.ccNo=payment.getCcNo();
        paymentEntity.amount=payment.getAmount();
        paymentEntity.status = Status.ACTIVE;
        return paymentEntity;
    }

    public Payment toModel() {
        return Payment.builder()
                .id(id)
                .userId(userId)
                .cvv(cvv)
                .expireDate(expireDate)
                .cardType(cardType)
                .ccNo(ccNo)
                .amount(amount)
                .build();
    }
}
