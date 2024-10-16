package com.tco.gameplaying;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import com.tco.gamemanagement.User;
import com.tco.usermanagement.History;
import com.tco.gameplaying.Rules;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestMatch {

    private Match match;

    @BeforeEach
    public void setUp() {
        List<User> users = new ArrayList<>();
        Rules rules = new Rules();
        History history = new History();
        match = new Match(users, history, rules);
    }

    @Test
    @DisplayName("johnh9 test: Test Match Creation")
    public void testMatchCreation() {
        assertNotNull(match);
    }
}
