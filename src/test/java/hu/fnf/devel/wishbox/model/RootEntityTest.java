package hu.fnf.devel.wishbox.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class RootEntityTest {
    RootEntity testRootEntity;
    String testString;

    @Before
    public void setUp() throws Exception {
        testRootEntity = new RootEntity();
        testString = "cica";
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetId() throws Exception {
        Field field = testRootEntity.getClass().getDeclaredField("id");

        field.setAccessible(true);
        field.set(testRootEntity, testString);


        assertEquals(testString, testRootEntity.getId());
    }

    @Test
    public void testSetId() throws Exception {
        testRootEntity.setId(testString);
        assertEquals(testString, testRootEntity.getId());
    }
}