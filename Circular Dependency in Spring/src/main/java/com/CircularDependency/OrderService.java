package com.CircularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    // We can avoid field injection after resolving circular dependency
//    @Autowired // Field Injection
    private final PaymentService paymentService;

    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.pay();

        // Getting order details is the responsibility of OrderService class
        getOrderDetails();
        System.out.println("Order Placed");
    }

    public void getOrderDetails() {
        System.out.println("Order Details:- abc...xyz");
    }

}
