package com.aop.payment.service.entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    @Column(nullable = false)
    private String user; 
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private LocalDateTime paymentDate;
   
    public Payment() {}

    public Payment(String user, Double amount) {
        this.user = user;
        this.amount = amount;
        this.status = status;
        this.paymentDate = LocalDateTime.now();
    }

    
    public Long getId() { return id; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
    
}

