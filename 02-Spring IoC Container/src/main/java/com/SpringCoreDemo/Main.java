package com.SpringCoreDemo;

import com.TestingWork.CartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

//        CartService cs = new CartService();
//        cs.addToCart();

//        User user = context.getBean(User.class);
//        System.out.println(user.getName());
//
//        CartService cart = context.getBean(CartService.class);
//        cart.addToCart();

//        PaymentService payment = context.getBean(PaymentService.class);
//        payment.pay();
    }
}

