package hu.fnf.devel.wishbox.model;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class NotificationTest {
    private String testString = "cica";

    @Test
    public void testGetTime() throws Exception {
        Notification testNotification = new Notification();

        Date localTime = new Date();

        Field field = testNotification.getClass().getDeclaredField("time");
        field.setAccessible(true);
        field.set(testNotification, localTime);

        assertEquals(localTime, testNotification.getTime());
    }

    @Test
    public void testGetText() throws Exception {
        Notification testNotification = new Notification();

        Field field = testNotification.getClass().getDeclaredField("text");
        field.setAccessible(true);
        field.set(testNotification, testString);

        assertEquals(testString, testNotification.getText());
    }

    @Test
    public void testSetText() throws Exception {
        Notification testNotification = new Notification();

        testNotification.setText(testString);

        assertEquals(testString, testNotification.getText());
    }

    @Test
    public void testGetPriority() throws Exception {
        Notification testNotification = new Notification();
        Enums.Priority testPriority = Enums.Priority.DANGER;

        Field field = testNotification.getClass().getDeclaredField("priority");
        field.setAccessible(true);
        field.set(testNotification, testPriority);

        assertEquals(testPriority, testNotification.getPriority());
    }

    @Test
    public void testSetPriority() throws Exception {
        Notification testNotification = new Notification();
        Enums.Priority testPriority = Enums.Priority.DANGER;

        testNotification.setPriority(testPriority);
        assertEquals(testPriority, testNotification.getPriority());
    }
}