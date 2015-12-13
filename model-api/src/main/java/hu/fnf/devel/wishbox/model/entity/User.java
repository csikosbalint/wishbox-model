package hu.fnf.devel.wishbox.model.entity;

import java.util.List;

public interface User extends Entity {
    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    List<Wish> getWishes();

    List<Notification> getNotifications();

    void addNotification(Notification notification);

    void addWish(Wish wish);

    void removeWish(Wish wish);

    void removeNotification(Notification notification);
}
