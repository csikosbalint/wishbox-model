package hu.fnf.devel.wishbox.model.entity.mongo;

import hu.fnf.devel.wishbox.model.entity.api.INotification;
import hu.fnf.devel.wishbox.model.entity.api.IWish;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserMongoTest {
    public static final String NOTTHESAME = "notthesame";
    private static final String testString = "cica";
    private UserMongo testUser;

    @Before
    public void setUp() throws Exception {
        testUser = new UserMongo(null, null, null);
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
        List<WishMongo> testWishList = new ArrayList<>();
        Field field = testUser.getClass().getDeclaredField("wishes");
        field.setAccessible(true);
        field.set(testUser, testWishList);

        assertEquals(testWishList, testUser.getWishes());
    }

    @Test
    public void testGetNotifications() throws Exception {
        List<NotificationMongo> testNotifications = new ArrayList<>();
        Field field = testUser.getClass().getDeclaredField("notifications");
        field.setAccessible(true);
        field.set(testUser, testNotifications);

        assertEquals(testNotifications, testUser.getNotifications());
    }

    @Test
    public void testAddNotification() throws Exception {
        List<NotificationMongo> testNotifications = new ArrayList<>();
        Field field = testUser.getClass().getDeclaredField("notifications");
        field.setAccessible(true);
        field.set(testUser, testNotifications);

        testUser.addNotification(new NotificationMongo());

        assertEquals(1, testUser.getNotifications().size());
    }

    @Test
    public void testAddWish() throws Exception {
        List<WishMongo> testWishList = new ArrayList<>();
        Field field = testUser.getClass().getDeclaredField("wishes");
        field.setAccessible(true);
        field.set(testUser, testWishList);

        testUser.addWish(new WishMongo());

        assertEquals(1, testUser.getWishes().size());
    }

    @Test
    public void testRemoveWish() throws Exception {
        List<WishMongo> testWishList = new ArrayList<>();
        WishMongo testWish = new WishMongo();
        Field field = testWish.getClass().getSuperclass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(testWish, testString);

        testWishList.add(testWish);
        field = testUser.getClass().getDeclaredField("wishes");
        field.setAccessible(true);
        field.set(testUser, testWishList);

        testUser.removeWish(testWish);

        assertEquals(0, testUser.getWishes().size());
    }

    @Test
    public void testRemoveNotification() throws Exception {
        List<NotificationMongo> testNotifications = new ArrayList<>();
        NotificationMongo testNotification = new NotificationMongo();
        Field field = testNotification.getClass().getSuperclass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(testNotification, testString);

        testNotifications.add(testNotification);
        field = testUser.getClass().getDeclaredField("notifications");
        field.setAccessible(true);
        field.set(testUser, testNotifications);

        testUser.removeNotification(testNotification);

        assertEquals(0, testUser.getNotifications().size());
    }

    @Test
    public void testRemoveNonExistingWish() throws Exception {
        List<IWish> testWishList = new ArrayList<>();
        WishMongo testWish = new WishMongo();
        Field field = testWish.getClass().getSuperclass().getDeclaredField("id");

        field.setAccessible(true);
        field.set(testWish, testString);

        testWishList.add(testWish);

        field = testUser.getClass().getDeclaredField("wishes");
        field.setAccessible(true);
        field.set(testUser, testWishList);

        WishMongo notTheSame = new WishMongo();
        field = notTheSame.getClass().getSuperclass().getDeclaredField("id");

        field.setAccessible(true);
        field.set(notTheSame, NOTTHESAME);

        testUser.removeWish(notTheSame);

        assertEquals(1, testUser.getWishes().size());
    }

    @Test
    public void testRemoveNonExistingNotification() throws Exception {
        List<INotification> testNotifications = new ArrayList<>();
        NotificationMongo testNotification = new NotificationMongo();
        Field field = testNotification.getClass().getSuperclass().getDeclaredField("id");

        field.setAccessible(true);
        field.set(testNotification, testString);

        testNotifications.add(testNotification);

        field = testUser.getClass().getDeclaredField("notifications");
        field.setAccessible(true);
        field.set(testUser, testNotifications);

        NotificationMongo notTheSame = new NotificationMongo();
        field = notTheSame.getClass().getSuperclass().getDeclaredField("id");

        field.setAccessible(true);
        field.set(notTheSame, NOTTHESAME);

        testUser.removeNotification(notTheSame);

        assertEquals(1, testUser.getNotifications().size());
    }
}