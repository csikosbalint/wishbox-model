
package hu.fnf.devel.wishbox.model.entity;

import hu.fnf.devel.wishbox.model.entity.api.IEvent;

import java.util.Date;

public class Event implements IEvent {
    private String id;
    private Date time;
    private String text;
    private String title;
    private Priority priority;
    private String icon;

    public Event() {
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
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
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
    public String getIcon() {
        return icon;
    }

    @Override
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String getId() {
        return id;
    }
}
