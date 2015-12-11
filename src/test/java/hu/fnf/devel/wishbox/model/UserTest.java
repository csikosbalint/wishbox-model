package hu.fnf.devel.wishbox.model;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User testUser;
    private String testString;

    @Before
    public void setUp() throws Exception {
        testString = "cica";
        testUser = new User(null, null, null);
    }

    @Test
    public void testGetFirstName() throws Exception {
        Field field = testUser.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(testUser, testString);

        assertEquals(testString, testUser.getFirstName());
    }

    @Test
    public void testSetFirstName() throws Exception {
        testUser.setFirstName(testString);
        assertEquals(testString, testUser.getFirstName());
    }

    @Test
    public void testGetLastName() throws Exception {
        Field field = testUser.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(testUser, testString);

        assertEquals(testString, testUser.getLastName());
    }

    @Test
    public void testSetLastName() throws Exception {
        testUser.setLastName(testString);
        assertEquals(testString, testUser.getLastName());
    }

    @Test
    public void testGetWishes() throws Exception {
        List<Wish> testWishList = new ArrayList<>();
        Field field = testUser.getClass().getDeclaredField("wishes");
        field.setAccessible(true);
        field.set(testUser, testWishList);

        assertEquals(testWishList, testUser.getWishes());
    }

    @Test
    public void testGetNotifications() throws Exception {
        List<Notification> testNotifications = new ArrayList<>();
        Field field = testUser.getClass().getDeclaredField("notifications");
        field.setAccessible(true);
        field.set(testUser, testNotifications);

        assertEquals(testNotifications, testUser.getNotifications());
    }

    @Test
    public void testAddNotification() throws Exception {
        List<Notification> testNotifications = new ArrayList<>();
        Field field = testUser.getClass().getDeclaredField("notifications");
        field.setAccessible(true);
        field.set(testUser, testNotifications);

        testUser.addNotification(new Notification());

        assertEquals(1, testUser.getNotifications().size());
    }

    @Test
    public void testAddWish() throws Exception {
        List<Wish> testWishList = new ArrayList<>();
        Field field = testUser.getClass().getDeclaredField("wishes");
        field.setAccessible(true);
        field.set(testUser, testWishList);

        testUser.addWish(new Wish());

        assertEquals(1, testUser.getWishes().size());
    }

    @Test
    public void testRemoveWish() throws Exception {
        List<Wish> testWishList = new ArrayList<>();
        Wish testWish = new Wish();
        testWish.setId(testString);
        testWishList.add(testWish);
        Field field = testUser.getClass().getDeclaredField("wishes");
        field.setAccessible(true);
        field.set(testUser, testWishList);

        testUser.removeWish(testWish);

        assertEquals(0, testUser.getWishes().size());
    }

    @Test
    public void testRemoveNotification() throws Exception {
        List<Notification> testNotifications = new ArrayList<>();
        Notification testNotification = new Notification();
        testNotification.setId(testString);
        testNotifications.add(testNotification);
        Field field = testUser.getClass().getDeclaredField("notifications");
        field.setAccessible(true);
        field.set(testUser, testNotifications);

        testUser.removeNotification(testNotification);

        assertEquals(0, testUser.getNotifications().size());
    }
}