
package hu.fnf.devel.wishbox.model.entity;

import hu.fnf.devel.wishbox.model.entity.api.INotification;
import hu.fnf.devel.wishbox.model.entity.api.IUser;
import hu.fnf.devel.wishbox.model.entity.api.IWish;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private String id;
    private String firstName;
    private String lastName;
    private List<IWish> wishes;
    private List<INotification> notifications;

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.notifications = new ArrayList<>();
        this.wishes = new ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public List<IWish> getWishes() {
        return wishes;
    }

    @Override
    public List<INotification> getNotifications() {
        return notifications;
    }

    @Override
    public void addNotification(INotification notification) {
        this.notifications.add(notification);
    }

    @Override
    public void addWish(IWish wish) {
        this.wishes.add(wish);
    }

    @Override
    public void removeWish(IWish wish) {
        for (IWish w : this.wishes) {
            if (w.getId().equals(wish.getId())) {
                this.wishes.remove(w);
                return;
            }
        }
    }

    @Override
    public void removeNotification(INotification notification) {
        for (INotification n : this.notifications) {
            if (n.getId().equals(notification.getId())) {
                this.notifications.remove(n);
                return;
            }
        }
    }
}
