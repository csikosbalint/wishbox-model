package hu.fnf.devel.wishbox.model.entity.mongo;

import hu.fnf.devel.wishbox.model.entity.Priority;
import hu.fnf.devel.wishbox.model.entity.api.INotification;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "notifications")
public class NotificationMongo extends EntityMongo implements INotification {
    private Date time;
    private String text;
    private Priority priority;

    public NotificationMongo() {
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
}
