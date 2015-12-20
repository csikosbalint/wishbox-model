/*
 *   Notification.java is part of the "wishbox ( model )" project
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

import hu.fnf.devel.wishbox.model.entity.Enums;
import hu.fnf.devel.wishbox.model.entity.Notification;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "notifications")
public class NotificationMongo extends EntityMongo implements Notification {
    private Date time;
    private String text;
    private Enums.Priority priority;

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
    public Enums.Priority getPriority() {
        return priority;
    }

    @Override
    public void setPriority(Enums.Priority priority) {
        this.priority = priority;
    }
}
