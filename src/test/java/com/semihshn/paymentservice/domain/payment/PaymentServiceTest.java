package com.semihshn.paymentservice.domain.payment;

import com.semihshn.paymentservice.adapter.jpa.payment.CardType;
import com.semihshn.paymentservice.domain.port.PaymentPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    PaymentService paymentService;

    @Mock
    PaymentPort paymentPort;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentService(paymentPort);
    }

    @Test
    void create() {
        //given
        Payment payment = Payment.builder().build();

        //mock
        Payment createdPayment = Payment.builder().id(3L).build();
        when(paymentPort.create(any())).thenReturn(createdPayment);

        //when
        Long createdPaymentId = paymentService.create(payment);

        //then
        assertThat(createdPaymentId).isEqualTo(3);
    }

    @Test
    void retrieve() {
        //mock
        when(paymentService.retrieve(anyLong())).thenReturn(Payment.builder().build());

        Payment mockPayment = Payment.builder()
                .id(1L)
                .userId(1L)
                .cvv("225")
                .expireDate("2022-10-01")
                .cardType(CardType.CREDIT)
                .ccNo("1234567890876543")
                .amount(new BigInteger("9999999999999999"))
                .build();

        when(paymentService.retrieve(1L)).thenReturn(mockPayment);

        //when
        Payment payment = paymentService.retrieve(1L);

        //then
        assertThat(payment).isNotNull();
        assertThat(payment.getId()).isEqualTo(1L);
        assertThat(payment.getAmount()).isEqualTo("9999999999999999");
        assertThat(payment.getCardType()).isEqualTo(CardType.CREDIT);
    }

    @Test
    void delete() {
    }
}