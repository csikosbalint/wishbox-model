package hu.fnf.devel.wishbox.model.entity.api;

import java.util.Date;
import java.util.List;

public interface IWish {
    String getId();

    Date getTime();

    String getLabel();

    void setLabel(String label);

    List<IEvent> getEvents();

    List<INotification> getNotifications();

    void addNotification(INotification notification);

    void addEvent(IEvent event);

    void addKeyword(String keyword);

    void removeEvent(IEvent event);

    void removeNotification(INotification notification);
}
