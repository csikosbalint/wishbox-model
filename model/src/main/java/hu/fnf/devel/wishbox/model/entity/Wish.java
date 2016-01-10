
package hu.fnf.devel.wishbox.model.entity;

import hu.fnf.devel.wishbox.model.entity.api.IEvent;
import hu.fnf.devel.wishbox.model.entity.api.INotification;
import hu.fnf.devel.wishbox.model.entity.api.IWish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Wish implements IWish {
    private String id;
    private String label;
    private List<String> keywords;
    private Date time;
    private List<IEvent> events;
    private List<INotification> notifications;

    public Wish() {
        this.time = new Date();
        this.events = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.keywords = new ArrayList<>();
    }

    public Wish(IWish w) {
        this.label = w.getLabel();
        this.time = new Date();
        this.events = new ArrayList<>(w.getEvents());
        this.notifications = new ArrayList<>(w.getNotifications());
        this.keywords = new ArrayList<>();
        this.keywords.add(w.getLabel());
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

    @Override
    public String getId() {
        return id;
    }
}
