
package hu.fnf.devel.wishbox.model.entity;

import hu.fnf.devel.wishbox.model.entity.api.INotification;

import java.util.Date;

public class Notification implements INotification {
    private String id;
    private Date time;
    private String text;
    private Priority priority;

    public Notification() {
        this.time = new Date();
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String getId() {
        return id;
    }
}
