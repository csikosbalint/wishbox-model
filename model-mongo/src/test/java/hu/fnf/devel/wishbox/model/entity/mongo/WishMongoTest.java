package hu.fnf.devel.wishbox.model.entity.mongo;

import hu.fnf.devel.wishbox.model.entity.Event;
import hu.fnf.devel.wishbox.model.entity.Notification;
import hu.fnf.devel.wishbox.model.entity.Wish;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SuppressWarnings("unchecked")
public class WishMongoTest {
    private static final String NOTTHESAME = "notthesame";
    private Wish testWish;
    private String testString;

    @Before
    public void setUp() throws Exception {
        testString = "cica";
        testWish = new WishMongo();
    }

    @Test
    public void testGetTime() throws Exception {
        Date testDate = new Date();
        Field field = testWish.getClass().getDeclaredField("time");
        field.setAccessible(true);
        field.set(testWish, testDate);

        assertEquals(testDate, testWish.getTime());
    }

    @Test
    public void testGetLabel() throws Exception {
        Field field = testWish.getClass().getDeclaredField("label");
        field.setAccessible(true);
        field.set(testWish, testString);

        assertEquals(testString, testWish.getLabel());
    }

    @Test
    public void testSetLabel() throws Exception {
        testWish.setLabel(testString);
        assertEquals(testString, testWish.getLabel());
    }

    @Test
    public void testGetEvents() throws Exception {
        List<Event> testEvents = new ArrayList<>();
        Field field = testWish.getClass().getDeclaredField("events");
        field.setAccessible(true);
        field.set(testWish, testEvents);

        assertEquals(testEvents, testWish.getEvents());
    }

    @Test
    public void testGetNotifications() throws Exception {
        List<Notification> testNotifications = new ArrayList<>();
        Field field = testWish.getClass().getDeclaredField("notifications");
        field.setAccessible(true);
        field.set(testWish, testNotifications);

        assertEquals(testNotifications, testWish.getNotifications());
    }

    @Test
    public void testAddNotification() throws Exception {
        List<Notification> testNotifications = new ArrayList<>();
        Field field = testWish.getClass().getDeclaredField("notifications");
        field.setAccessible(true);
        field.set(testWish, testNotifications);

        testWish.addNotification(new NotificationMongo());

        assertEquals(1, testWish.getNotifications().size());
    }

    @Test
    public void testAddEvent() throws Exception {
        List<Event> testEvents = new ArrayList<>();
        Field field = testWish.getClass().getDeclaredField("events");
        field.setAccessible(true);
        field.set(testWish, testEvents);

        testWish.addEvent(new EventMongo());

        assertEquals(1, testWish.getEvents().size());
    }

    @Test
    public void testAddKeyword() throws Exception {
        List<String> testKeywords = new ArrayList<>();
        Field field = testWish.getClass().getDeclaredField("keywords");
        field.setAccessible(true);
        field.set(testWish, testKeywords);

        testWish.addKeyword(testString);

        //noinspection unchecked
        assertEquals(1, ((List<String>) field.get(testWish)).size());
    }

    @Test
    public void testRemoveEvent() throws Exception {
        List<Event> testEvents = new ArrayList<>();
        Event testEvent = new EventMongo();
        Field field = testEvent.getClass().getSuperclass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(testEvent, testString);

        testEvents.add(testEvent);
        field = testWish.getClass().getDeclaredField("events");
        field.setAccessible(true);
        field.set(testWish, testEvents);

        testWish.removeEvent(testEvent);

        assertEquals(0, testWish.getEvents().size());
    }

    @Test
    public void testRemoveNonExistingEvent() throws Exception {
        List<Event> testEvents = new ArrayList<>();
        Event testEvent = new EventMongo();
        Field field = testEvent.getClass().getSuperclass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(testEvent, testString);

        testEvents.add(testEvent);
        field = testWish.getClass().getDeclaredField("events");
        field.setAccessible(true);
        field.set(testWish, testEvents);

        Event notTheSame = new EventMongo();
        field = notTheSame.getClass().getSuperclass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(notTheSame, NOTTHESAME);

        testWish.removeEvent(notTheSame);

        assertEquals(1, testWish.getEvents().size());
    }

    @Test
    public void testRemoveNotification() throws Exception {
        List<Notification> testNotifications = new ArrayList<>();
        Notification testNotification = new NotificationMongo();
        Field field = testNotification.getClass().getSuperclass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(testNotification, testString);

        testNotifications.add(testNotification);
        field = testWish.getClass().getDeclaredField("notifications");
        field.setAccessible(true);
        field.set(testWish, testNotifications);

        testWish.removeNotification(testNotification);

        assertEquals(0, testWish.getNotifications().size());
    }

    @Test
    public void testWish() {
        Wish testWish = new WishMongo();
        testWish.setLabel(testString);
        testWish.addEvent(new EventMongo());
        testWish.addKeyword(testString);
        testWish.addNotification(new NotificationMongo());

        Wish anotherWish = new WishMongo(testWish);

        assertNotNull(anotherWish.getLabel());
        assertNotNull(anotherWish.getTime());
        assertNotNull(anotherWish.getEvents());
        assertNotNull(anotherWish.getNotifications());
    }

    @Test
    public void testRemoveNonExistingNotification() throws Exception {
        List<Notification> testNotifications = new ArrayList<>();
        Notification testNotification = new NotificationMongo();

        Field field = testNotification.getClass().getSuperclass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(testNotification, testString);

        testNotifications.add(testNotification);
        field = testWish.getClass().getDeclaredField("notifications");
        field.setAccessible(true);
        field.set(testWish, testNotifications);

        Notification notTheSame = new NotificationMongo();
        field = notTheSame.getClass().getSuperclass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(notTheSame, NOTTHESAME);

        testWish.removeNotification(notTheSame);

        assertEquals(1, testWish.getNotifications().size());
    }

}