package com.semihshn.paymentservice.adapter.jpa.payment;

import com.semihshn.paymentservice.adapter.jpa.common.Status;
import com.semihshn.paymentservice.domain.exception.ExceptionType;
import com.semihshn.paymentservice.domain.exception.SemDataNotFoundException;
import com.semihshn.paymentservice.domain.payment.Payment;
import com.semihshn.paymentservice.domain.port.PaymentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentJpaAdapter implements PaymentPort {
    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment create(Payment payment) {
        return paymentJpaRepository.save(PaymentEntity.from(payment)).toModel();
    }

    @Override
    public void delete(Long id) {
        paymentJpaRepository.findById(id)
                .ifPresent(user -> {
                    user.setStatus(Status.DELETED);
                    paymentJpaRepository.save(user);
                });
    }

    @Override
    public Payment retrieve(Long id) {
        return retrievePaymentEntity(id)
                .toModel();
    }

    private PaymentEntity retrievePaymentEntity(Long id) {
        return paymentJpaRepository.findById(id)
                .orElseThrow(() -> new SemDataNotFoundException(ExceptionType.PAYMENT_DATA_NOT_FOUND));
    }
}
