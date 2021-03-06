package hu.fnf.devel.wishbox.model.entity.mongo;

import hu.fnf.devel.wishbox.model.entity.api.IEvent;
import hu.fnf.devel.wishbox.model.entity.api.INotification;
import hu.fnf.devel.wishbox.model.entity.api.IWish;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "wishes")
public class WishMongo extends EntityMongo implements IWish {
    private String label;
    private List<String> keywords;
    private Date time;
    @DBRef
    private List<IEvent> events;
    @DBRef
    private List<INotification> notifications;

    public WishMongo() {
        this.time = new Date();
        this.events = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.keywords = new ArrayList<>();
    }

    public WishMongo(IWish w) {
        this.label = w.getLabel();
        this.time = new Date();
        this.events = new ArrayList<>(w.getEvents());
        this.notifications = new ArrayList<>(w.getNotifications());
        this.keywords = new ArrayList<>();
        this.keywords.add(w.getLabel());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public List<IEvent> getEvents() {
        return events;
    }

    @Override
    public List<INotification> getNotifications() {
        return notifications;
    }

    @Override
    public void addNotification(INotification notification) {
        notifications.add(notification);
    }

    @Override
    public void addEvent(IEvent event) {
        events.add(event);
    }

    @Override
    public void addKeyword(String keyword) {
        keywords.add(keyword);
    }

    @Override
    public void removeEvent(IEvent event) {
        for (IEvent e : this.events) {
            if (e.getId().equals(event.getId())) {
                this.events.remove(e);
                break;
            }
        }
    }

    @Override
    public void removeNotification(INotification notification) {
        for (INotification n : this.notifications) {
            if (n.getId().equals(notification.getId())) {
                this.notifications.remove(n);
                break;
            }
        }
    }

}
