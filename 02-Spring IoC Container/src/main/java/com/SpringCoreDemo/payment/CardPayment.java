package com.SpringCoreDemo.payment;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Qualifier
public class CardPayment implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Payment done through card");
    }
}
