package com.semihshn.paymentservice.adapter.jpa.payment;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, Long> {
}
