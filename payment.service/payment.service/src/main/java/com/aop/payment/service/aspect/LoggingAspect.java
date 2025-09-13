package com.aop.payment.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.aop.payment.service.service.PaymentService.processPayment(..))")
    public void logBeforePayment() {
        System.out.println("LoggingAspect: Payment process is about to start.");
    }

    @After("execution(* com.aop.payment.service.service.PaymentService.processPayment(..))")
    public void logAfter(JoinPoint jp) {
        System.out.println("After: Completed payment processing");
    }

    @Around("execution(* com.aop.payment.service.service.PaymentService.processPayment(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around (before): starting payment...");
        Object result = pjp.proceed();
        System.out.println("Around (after): payment done.");
        return result;
    }
}
