package com.SpringCoreDemo;

import com.SpringCoreDemo.notification.EmailService;
import com.SpringCoreDemo.notification.NotificationService;
import com.SpringCoreDemo.notification.PopUpNotificationService;
import com.SpringCoreDemo.notification.SmsService;

public class OrderService {

    NotificationService notification;

    public OrderService(NotificationService notification) {
        this.notification = notification;
    }

    public OrderService() {

    }

    public void placeOrder() {
        System.out.println("Order Placed");
        // Actual business logic....
        notification.sendNotification();
    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }
}


// A class should ask what it needs, and not build everything itself.
