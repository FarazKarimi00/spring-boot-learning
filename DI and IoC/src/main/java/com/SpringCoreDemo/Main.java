package com.SpringCoreDemo;

import com.SpringCoreDemo.notification.*;

public class Main {
    public static void main(String[] args) {
        NotificationService notification = new EmailService();
//        OrderService order = new OrderService(notification);
        OrderService order = new OrderService();
        order.setNotification(notification);
        order.placeOrder();
    }
}

