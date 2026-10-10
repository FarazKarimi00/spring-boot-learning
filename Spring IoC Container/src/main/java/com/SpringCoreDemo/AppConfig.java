package com.SpringCoreDemo;

import com.SpringCoreDemo.payment.CardPayment;
import com.SpringCoreDemo.payment.PaymentService;
import com.SpringCoreDemo.payment.UPIPayment;
import com.TestingWork.CartService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.SpringCoreDemo")
public class AppConfig {
    @Bean
    public User createUser() {
        return new User("Faraz", 21);
    }
    @Bean
    public CartService createCartService() {
        return new CartService();
    }
//    @Bean
//    @Qualifier("cardPayment")
//    public PaymentService createCardPayment() {
//        return new CardPayment();
//    }
//    @Bean
//    @Qualifier("UPIPayment")
//    public PaymentService createUPIPayment() {
//        return new UPIPayment();
//    }
//    @Bean
//    public OrderService createOrderService(@Qualifier("UPIPayment") PaymentService paymentService) {
//        return new OrderService(paymentService);
//    }
}
