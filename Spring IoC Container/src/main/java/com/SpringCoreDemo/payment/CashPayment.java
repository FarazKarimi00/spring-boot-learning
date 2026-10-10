package com.SpringCoreDemo.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier
public class CashPayment implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Payment done via cash");
    }
}
