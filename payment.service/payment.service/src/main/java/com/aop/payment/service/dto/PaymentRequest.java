package com.aop.payment.service.dto;

public class PaymentRequest {
    private String user;
    private Double amount;

    
    public PaymentRequest() {}

  
    public PaymentRequest(String user, Double amount) {
        this.user = user;
        this.amount = amount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}