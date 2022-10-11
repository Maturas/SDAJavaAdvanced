package org.SDA.Notifications;

public class DesktopInternetBrowser implements NotificationHandlerInterface {

    @Override
    public void handleNotification(String notification) {
        System.out.println("Displaying the notification in a new browser card:");
        System.out.println(notification);
    }
}
