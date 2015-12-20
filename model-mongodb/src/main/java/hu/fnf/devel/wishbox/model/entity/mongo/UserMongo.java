/*
 *   User.java is part of the "wishbox ( model )" project
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

import hu.fnf.devel.wishbox.model.entity.Notification;
import hu.fnf.devel.wishbox.model.entity.User;
import hu.fnf.devel.wishbox.model.entity.Wish;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class UserMongo extends EntityMongo implements User {

    private String firstName;
    private String lastName;
    @DBRef
    private List<Wish> wishes;
    @DBRef
    private List<Notification> notifications;

    public UserMongo(String id, String firstName, String lastName) {
        super.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.notifications = new ArrayList<>();
        this.wishes = new ArrayList<>();
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public List<Wish> getWishes() {
        return wishes;
    }

    @Override
    public List<Notification> getNotifications() {
        return notifications;
    }

    @Override
    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    @Override
    public void addWish(Wish wish) {
        this.wishes.add(wish);
    }

    @Override
    public void removeWish(Wish wish) {
        for (Wish w : this.wishes) {
            if (w.getId().equals(wish.getId())) {
                this.wishes.remove(w);
                return;
            }
        }
    }

    @Override
    public void removeNotification(Notification notification) {
        for (Notification n : this.notifications) {
            if (n.getId().equals(notification.getId())) {
                this.notifications.remove(n);
                return;
            }
        }
    }
}
