package hu.fnf.devel.wishbox.model.entity.mongo;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class EntityMongoTest {
    EntityMongo testEntityMongo;
    String testString;

    @Before
    public void setUp() throws Exception {
        testEntityMongo = new EntityMongo();
        testString = "cica";
    }

    @Test
    public void testGetId() throws Exception {
        Field field = testEntityMongo.getClass().getDeclaredField("id");

        field.setAccessible(true);
        field.set(testEntityMongo, testString);

        assertEquals(testString, testEntityMongo.getId());
    }

}