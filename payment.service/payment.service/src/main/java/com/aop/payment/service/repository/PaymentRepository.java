package com.aop.payment.service.repository;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

import com.aop.payment.service.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	 List<Payment> findByUser(String user);
	 
	 List<Payment> findByStatus(String status);
	 
	 List<Payment> findByAmountGreaterThan(Double amount);

	 Page<Payment> findAll(Pageable pageable);
	
	 List<Payment> findAll(Sort sort);
	 
	 @Query("SElECT p FROM Payment p WHERE p.amount>:amount")
	 List<Payment> findPaymentsAboveAmount(@Param ("amount") Double amount);
	 
	
	 @Query(value = "SELECT * FROM payment WHERE status = status"
	 		+ "", nativeQuery = true)
	    List<Payment> findByStatusNative(String status);
}
