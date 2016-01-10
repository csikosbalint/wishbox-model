package hu.fnf.devel.wishbox.model.entity.api;

import hu.fnf.devel.wishbox.model.entity.Priority;

import java.util.Date;

public interface IEvent {

    String getId();

    Date getTime();

    String getText();

    void setText(String text);

    String getTitle();

    void setTitle(String title);

    Priority getPriority();

    void setPriority(Priority priority);

    String getIcon();

    void setIcon(String icon);
}
