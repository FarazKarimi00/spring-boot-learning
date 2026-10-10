package com.SpringCoreDemo;

import com.SpringCoreDemo.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

//    @Autowired // Field injection
    private final PaymentService paymentService;

    @Autowired // Constructor injection(Recommended) Also no need to write auto wired notation if we only have one constructor
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // setter of PaymentService
//    @Autowired // Setter injection
//    public void setPaymentService(PaymentService paymentService) {
//         this.paymentService = paymentService;
//    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order placed");
    }
}
