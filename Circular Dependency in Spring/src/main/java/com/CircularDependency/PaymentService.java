package com.CircularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    // No need after Removing circular dependency
//    @Autowired // Field Injection (to avoid circular dependency)
//    private OrderService orderService;

//    @Autowired
//    public PaymentService(OrderService orderService) {
//        this.orderService = orderService;
//    }

    public void pay() {
        System.out.println("Payment done");

        // Getting order details is not the responsibility of Payment Service class
//        orderService.getOrderDetails();
    }
}
