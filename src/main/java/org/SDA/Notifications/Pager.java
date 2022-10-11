package org.SDA.Notifications;

public class Pager implements NotificationHandlerInterface {
    @Override
    public void handleNotification(String notification) {
        System.out.println("Displaying notification's text on pager screen:");
        System.out.println(notification);
    }
}
