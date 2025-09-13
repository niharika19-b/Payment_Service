package com.aop.payment.service.controller;
import com.aop.payment.service.dto.PaymentRequest;
import com.aop.payment.service.entity.Payment;
import com.aop.payment.service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public String processPayment(@RequestBody PaymentRequest request) {
        System.out.println("Received user: " + request.getUser());
        System.out.println("Received amount: " + request.getAmount());
        paymentService.processPayment(request.getUser(), request.getAmount());
        return "Payment request processed.";
    }

    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

   @GetMapping("/paged")
    public List<Payment> getPagedPayments(@RequestParam int page, @RequestParam int size) {
        return paymentService.getPaymentsPaged(page, size).getContent();
    }

   @GetMapping("/sorted")
    public List<Payment> getSortedPayments() {
        return paymentService.getPaymentsSorted();
    }

   @GetMapping("/above/{amount}")
    public List<Payment> getPaymentsAboveAmount(@PathVariable double amount) {
        return paymentService.findPaymentsAboveAmount(amount);
    }

    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable String status) {
        return paymentService.findByStatusNative(status);
    }

   @GetMapping("/id/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    
   @DeleteMapping("/id/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment with id " + id + " deleted.";
    }
}
