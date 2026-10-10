package com.SpringCoreDemo.notification;

public class FakeEmailService implements NotificationService{
    @Override
    public void sendNotification() {
        System.out.println("Dummy email send");
    }
}
