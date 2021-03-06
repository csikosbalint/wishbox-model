package hu.fnf.devel.wishbox.model.entity.mongo;

import hu.fnf.devel.wishbox.model.entity.Priority;
import hu.fnf.devel.wishbox.model.entity.api.IEvent;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "events")
public class EventMongo extends EntityMongo implements IEvent {
    private Date time;
    private String text;
    private String title;
    private Priority priority;
    private String icon;

    public EventMongo() {
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
}
