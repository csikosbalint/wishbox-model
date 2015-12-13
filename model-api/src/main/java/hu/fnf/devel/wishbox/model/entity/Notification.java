package hu.fnf.devel.wishbox.model.entity;

import java.util.Date;

public interface Notification extends Entity {
    Date getTime();

    String getText();

    void setText(String text);

    Enums.Priority getPriority();

    void setPriority(Enums.Priority priority);
}
