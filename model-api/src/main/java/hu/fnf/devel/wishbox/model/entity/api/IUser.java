package hu.fnf.devel.wishbox.model.entity.api;

import java.util.List;

public interface IUser {
    String getId();

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    List<IWish> getWishes();

    List<INotification> getNotifications();

    void addNotification(INotification notification);

    void addWish(IWish wish);

    void removeWish(IWish wish);

    void removeNotification(INotification notification);
}
