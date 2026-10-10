package com.SpringCoreDemo.notification;

public class EmailService implements NotificationService {

    @Override
    public void sendNotification() {
        // Actual notification Send
        System.out.println("Email notification send");
    }
}
