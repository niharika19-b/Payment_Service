package com.aop.payment.service.listener;

import com.aop.payment.service.event.PaymentEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventListener {

    @EventListener
    public void handlePaymentEvent(PaymentEvent event) {
        System.out.println("Payment Event Received!");
        System.out.println("Payment ID: " + event.getPaymentId());
        System.out.println("User: " + event.getUser());
        System.out.println("Amount: " + event.getAmount());
        System.out.println("Created Date: " + event.getCreatedDate());
        System.out.println("Last Modified Date: " + event.getLastModifiedDate());

        
    }
}
