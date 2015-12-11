package hu.fnf.devel.wishbox.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class EventTest {
    Event testEvent;
    String testString;

    @Before
    public void setUp() throws Exception {
        testEvent = new Event();
        testString = "cica";
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetTime() throws Exception {
        Field field = testEvent.getClass().getDeclaredField("time");
        Date testDate = new Date();
        field.setAccessible(true);
        field.set(testEvent, testDate);

        assertEquals(testDate, testEvent.getTime());
    }

    @Test
    public void testGetText() throws Exception {
        Field field = testEvent.getClass().getDeclaredField("text");

        field.setAccessible(true);
        field.set(testEvent, testString);

        assertEquals(testString, testEvent.getText());
    }

    @Test
    public void testSetText() throws Exception {
        testEvent.setText(testString);
        assertEquals(testString, testEvent.getText());
    }

    @Test
    public void testGetTitle() throws Exception {
        Field field = testEvent.getClass().getDeclaredField("title");

        field.setAccessible(true);
        field.set(testEvent, testString);

        assertEquals(testString, testEvent.getTitle());
    }

    @Test
    public void testSetTitle() throws Exception {
        testEvent.setTitle(testString);
        assertEquals(testString, testEvent.getTitle());
    }

    @Test
    public void testGetPriority() throws Exception {
        Field field = testEvent.getClass().getDeclaredField("priority");
        Enums.Priority testPriority = Enums.Priority.danger;

        field.setAccessible(true);
        field.set(testEvent, testPriority);

        assertEquals(testPriority, testEvent.getPriority());
    }

    @Test
    public void testSetPriority() throws Exception {
        Enums.Priority testPriority = Enums.Priority.danger;
        testEvent.setPriority(testPriority);
        assertEquals(testPriority, testEvent.getPriority());
    }

    @Test
    public void testGetIcon() throws Exception {
        Field field = testEvent.getClass().getDeclaredField("icon");

        field.setAccessible(true);
        field.set(testEvent, testString);

        assertEquals(testString, testEvent.getIcon());
    }

    @Test
    public void testSetIcon() throws Exception {
        testEvent.setIcon(testString);
        assertEquals(testString, testEvent.getIcon());
    }
}