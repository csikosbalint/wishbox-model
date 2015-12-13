package hu.fnf.devel.wishbox.model.entity;

import java.util.Date;
import java.util.List;

public interface Wish extends Entity {
    Date getTime();

    String getLabel();

    void setLabel(String label);

    List<Event> getEvents();

    List<Notification> getNotifications();

    void addNotification(Notification notification);

    void addEvent(Event event);

    void addKeyword(String keyword);

    void removeEvent(Event event);

    void removeNotification(Notification notification);
}
