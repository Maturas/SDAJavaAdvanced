package org.SDA.Notifications;

public class Smartphone implements NotificationHandlerInterface {
    @Override
    public void handleNotification(String notification) {
        System.out.println("Displaying push notification:");
        System.out.println(notification);
    }
}
