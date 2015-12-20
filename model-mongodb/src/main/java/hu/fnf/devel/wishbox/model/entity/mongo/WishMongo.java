/*
 *   Wish.java is part of the "wishbox ( model )" project
 *   Copyright (C)  2015  author:  johnnym
 *
 *   This program is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU General Public License
 *   as published by the Free Software Foundation; either version 2
 *   of the License, or (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program; if not, write to the Free Software
 *   Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package hu.fnf.devel.wishbox.model.entity.mongo;

import hu.fnf.devel.wishbox.model.entity.Event;
import hu.fnf.devel.wishbox.model.entity.Notification;
import hu.fnf.devel.wishbox.model.entity.Wish;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "wishes")
public class WishMongo extends EntityMongo implements Wish {
    private String label;
    private List<String> keywords;
    private Date time;
    @DBRef
    private List<Event> events;
    @DBRef
    private List<Notification> notifications;

    public WishMongo() {
        this.time = new Date();
        this.events = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.keywords = new ArrayList<>();
    }

    public WishMongo(Wish w) {
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
    public List<Event> getEvents() {
        return events;
    }

    @Override
    public List<Notification> getNotifications() {
        return notifications;
    }

    @Override
    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    @Override
    public void addEvent(Event event) {
        events.add(event);
    }

    @Override
    public void addKeyword(String keyword) {
        keywords.add(keyword);
    }

    @Override
    public void removeEvent(Event event) {
        for (Event e : this.events) {
            if (e.getId().equals(event.getId())) {
                this.events.remove(e);
                break;
            }
        }
    }

    @Override
    public void removeNotification(Notification notification) {
        for (Notification n : this.notifications) {
            if (n.getId().equals(notification.getId())) {
                this.notifications.remove(n);
                break;
            }
        }
    }

}
