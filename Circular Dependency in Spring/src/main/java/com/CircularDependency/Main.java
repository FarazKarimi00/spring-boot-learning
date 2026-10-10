package com.CircularDependency;

import com.CircularDependency.Simple.A;
import com.CircularDependency.Simple.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

//        A a = new A();
    }
}

