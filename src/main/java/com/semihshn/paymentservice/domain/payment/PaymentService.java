package com.semihshn.paymentservice.domain.payment;

import com.semihshn.paymentservice.domain.port.PaymentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentPort paymentPort;

    public Long create(Payment payment) {
        Payment temp = paymentPort.create(payment);
        return temp.getId();
    }

    public Payment retrieve(Long id) {
        return paymentPort.retrieve(id);
    }

    public void delete(Long id) {
        paymentPort.delete(id);
    }
}
