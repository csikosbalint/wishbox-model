package hu.fnf.devel.wishbox.model.entity.mongo;

import hu.fnf.devel.wishbox.model.entity.Priority;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class NotificationMongoTest {
    private String testString = "cica";

    @Test
    public void testGetTime() throws Exception {
        NotificationMongo testNotification = new NotificationMongo();

        Date localTime = new Date();

        Field field = testNotification.getClass().getDeclaredField("time");
        field.setAccessible(true);
        field.set(testNotification, localTime);

        assertEquals(localTime, testNotification.getTime());
    }

    @Test
    public void testGetText() throws Exception {
        NotificationMongo testNotification = new NotificationMongo();

        Field field = testNotification.getClass().getDeclaredField("text");
        field.setAccessible(true);
        field.set(testNotification, testString);

        assertEquals(testString, testNotification.getText());
    }

    @Test
    public void testSetText() throws Exception {
        NotificationMongo testNotification = new NotificationMongo();

        testNotification.setText(testString);

        assertEquals(testString, testNotification.getText());
    }

    @Test
    public void testGetPriority() throws Exception {
        NotificationMongo testNotification = new NotificationMongo();
        Priority testPriority = Priority.DANGER;

        Field field = testNotification.getClass().getDeclaredField("priority");
        field.setAccessible(true);
        field.set(testNotification, testPriority);

        assertEquals(testPriority, testNotification.getPriority());
    }

    @Test
    public void testSetPriority() throws Exception {
        NotificationMongo testNotification = new NotificationMongo();
        Priority testPriority = Priority.DANGER;

        testNotification.setPriority(testPriority);
        assertEquals(testPriority, testNotification.getPriority());
    }
}