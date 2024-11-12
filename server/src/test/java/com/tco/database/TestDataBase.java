package com.tco.gamemanagement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import com.tco.usermanagement.Profile;
import com.tco.gameplaying.Match;
import com.tco.gameplaying.Rules;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.tco.database.*;
import com.tco.gamemanagement.User;

public class TestDataBase {

    private Database database;

    @BeforeEach
    public void createConfigurationForTestCases() {
        database = new Database();
    }

    @Test
    @DisplayName("sam25: testAdd")
    public void testProfile() {
        User user = new User("Test1");
        database.addUserDB(user);
        // assertEquals(platform.getProfile(), null);
    }
}