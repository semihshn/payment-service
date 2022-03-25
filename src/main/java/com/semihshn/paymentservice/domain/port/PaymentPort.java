package com.semihshn.paymentservice.domain.port;

import com.semihshn.paymentservice.domain.payment.Payment;

public interface PaymentPort {
    Payment create(Payment payment);

    void delete(Long id);

    Payment retrieve(Long id);
}
