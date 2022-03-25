package com.semihshn.paymentservice.adapter.rest.payment;

import com.semihshn.paymentservice.adapter.rest.payment.request.PaymentCreateRequest;
import com.semihshn.paymentservice.adapter.rest.payment.response.PaymentCreateResponse;
import com.semihshn.paymentservice.adapter.rest.payment.response.PaymentResponse;
import com.semihshn.paymentservice.domain.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping()
    public PaymentCreateResponse create(@RequestBody @Valid PaymentCreateRequest request) {
        Long createdPaymentId = paymentService.create(request.convertToPayment());
        return PaymentCreateResponse.builder().id(createdPaymentId).build();
    }

    @DeleteMapping("{paymentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long paymentId) {
        paymentService.delete(paymentId);
    }

    @GetMapping("{paymentId}")
    public PaymentResponse retrieve(@PathVariable Long paymentId) {
        return PaymentResponse.from(paymentService.retrieve(paymentId));
    }
}
