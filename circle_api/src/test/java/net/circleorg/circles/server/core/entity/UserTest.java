package net.circleorg.circles.server.core.entity;

import net.circleorg.circles.api.entity.User;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void canConstructAUserWithAName() {
        User person = new User("Larry");
        assertEquals("Larry", person.getName());
    }
    
    //TODO add some meanimgful tests
}
