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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.UUID;
import com.tco.database.*;
import com.tco.gamemanagement.User;

public class TestDataBase {

    private Database database;

    @BeforeEach
    public void createConfigurationForTestCases() {
        database = new Database();
    }

    @Test
    @DisplayName("sam25: testAddDB")
    public void testSimpleAdd() {
        User user = new User("Test1");
        //set the uuid so we dont over flood the DB
        UUID uuid = UUID.fromString("51220858-9033-47a1-8bf7-76533fe7926a");
        user.getProfile().setUserId(uuid);
        database.addUserDB(user);
        
        User retrievedUser = database.getUserById(uuid);
        System.out.println(retrievedUser.getProfile().getUserId() + "userIDDDD");
        assertEquals(uuid, retrievedUser.getProfile().getUserId());
        assertNotNull(retrievedUser.getUserName());
    }

    @Test
    @DisplayName("sam25: testUpdate DB")
    public void testSimpleUpdate() {
        User user = new User("Test1 UPDATE");
        //set the uuid so we dont over flood the DB
        UUID uuid = UUID.fromString("66720858-9033-48b2-8bf7-76533fe7926a");
        user.getProfile().setUserId(uuid);
        database.addUserDB(user);
        
        String newUserName = "newUser";
        user.getProfile().setUserName(newUserName);

        database.updateUserDB(user);

        User retrievedUser = database.getUserById(uuid);
        System.out.println(retrievedUser.getProfile().getUserId() + "userIDDDD");
        assertEquals(uuid, retrievedUser.getProfile().getUserId());
        assertEquals("newUser", retrievedUser.getUserName());
    }
}