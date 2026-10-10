package com.SpringCoreDemo.notification;

public class SmsService implements NotificationService{
    @Override
    public void sendNotification() {
        System.out.println("SMS notification send");
    }
}
