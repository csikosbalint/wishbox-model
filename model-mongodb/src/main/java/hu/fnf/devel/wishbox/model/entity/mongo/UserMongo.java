package hu.fnf.devel.wishbox.model.entity.mongo;

import hu.fnf.devel.wishbox.model.entity.api.INotification;
import hu.fnf.devel.wishbox.model.entity.api.IUser;
import hu.fnf.devel.wishbox.model.entity.api.IWish;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class UserMongo extends EntityMongo implements IUser {

    private String firstName;
    private String lastName;
    @DBRef
    private List<IWish> wishes;
    @DBRef
    private List<INotification> notifications;

    public UserMongo(String id, String firstName, String lastName) {
        super.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.notifications = new ArrayList<>();
        this.wishes = new ArrayList<>();
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
