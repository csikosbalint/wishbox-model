package hu.fnf.devel.wishbox.model.entity.api;

import hu.fnf.devel.wishbox.model.entity.Priority;

import java.util.Date;

public interface INotification {
    String getId();

    Date getTime();

    String getText();

    void setText(String text);

    Priority getPriority();

    void setPriority(Priority priority);

}
