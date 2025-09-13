package com.aop.payment.service.event;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

public class PaymentEvent extends ApplicationEvent {

    private final Long paymentId;
    private final String user;
    private final double amount;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;

    public PaymentEvent(Object source, Long paymentId, String user, double amount,
                        LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        super(source);
        this.paymentId = paymentId;
        this.user = user;
        this.amount = amount;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getPaymentId() { return paymentId; }
    public String getUser() { return user; }
    public double getAmount() { return amount; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    public LocalDateTime getLastModifiedDate() { return lastModifiedDate; }
}
