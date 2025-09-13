package com.aop.payment.service.service;
import com.aop.payment.service.entity.Payment;
import com.aop.payment.service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

  
    @Transactional
    public Payment processPayment(String user, double amount) {
        Payment payment = new Payment(user, amount);
        payment.setStatus("Pending");
        payment = paymentRepository.save(payment);
        System.out.println("Saved payment: " + user + " - " + amount);
        return payment;
    }

    
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    
    @Transactional
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    
    public Page<Payment> getPaymentsPaged(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return paymentRepository.findAll(pageRequest);
    }

    
    public List<Payment> getPaymentsSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "amount");
        return paymentRepository.findAll(sort);
    }

    
    public List<Payment> findPaymentsAboveAmount(double amount) {
        return paymentRepository.findPaymentsAboveAmount(amount);
    }

    
    public List<Payment> findByStatusNative(String status) {
        return paymentRepository.findByStatusNative(status);
    }
}
