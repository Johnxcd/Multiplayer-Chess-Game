package com.tco.gameplaying;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import com.tco.gamemanagement.User;
import com.tco.gameplaying.Rules;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestMatch {

    private Match match;

    @BeforeEach
    public void setUp() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User[] users = {user1, user2};
        Rules rules = new Rules();
        match = new Match(users, rules);
    }

    @Test
    @DisplayName("johnh9 test: Test Match Creation")
    public void testMatchCreation() {
        assertNotNull(match);
    }
}
