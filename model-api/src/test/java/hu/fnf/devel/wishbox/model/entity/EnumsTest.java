package hu.fnf.devel.wishbox.model.entity;

import org.junit.Test;

public class EnumsTest {
    private Enums.Priority priority;
    private Enums enums;

    @Test
    public void testEnums() {
        enums = new Enums();
        priority = Enums.Priority.DANGER;
    }
}
