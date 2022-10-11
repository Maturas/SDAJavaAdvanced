package org.SDA.Notifications;

import java.util.ArrayList;
import java.util.List;

public class NotificationCenter {
    private final List<NotificationHandlerInterface> notificationHandlers = new ArrayList<>();

    public void registerNotificationHandler(NotificationHandlerInterface handler) {
        notificationHandlers.add(handler);
    }

    public void emitNotification(String notification) {
        for (NotificationHandlerInterface handler : notificationHandlers) {
            handler.handleNotification(notification);
        }
    }

    public static void example() {
        NotificationCenter center = new NotificationCenter();

        DesktopInternetBrowser browser = new DesktopInternetBrowser();
        Smartphone xiaomi = new Smartphone();
        Smartphone samsung = new Smartphone();
        Smartphone iPhone = new Smartphone();
        Pager pager = new Pager();

        center.registerNotificationHandler(browser);
        center.registerNotificationHandler(xiaomi);
        center.registerNotificationHandler(samsung);
        center.registerNotificationHandler(iPhone);
        center.registerNotificationHandler(pager);

        center.emitNotification("Hello, World!");
    }
}
