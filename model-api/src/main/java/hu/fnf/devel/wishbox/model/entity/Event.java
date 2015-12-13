package hu.fnf.devel.wishbox.model.entity;

import java.util.Date;

public interface Event extends Entity {

    Date getTime();

    String getText();

    void setText(String text);

    String getTitle();

    void setTitle(String title);

    Enums.Priority getPriority();

    void setPriority(Enums.Priority priority);

    String getIcon();

    void setIcon(String icon);
}
