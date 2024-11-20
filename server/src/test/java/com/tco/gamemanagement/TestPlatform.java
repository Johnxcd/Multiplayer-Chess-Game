package com.tco.gamemanagement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.logging.Logger;
import com.tco.usermanagement.Profile;
import com.tco.gameplaying.Match;
import com.tco.gameplaying.Rules;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import java.util.UUID;

public class TestPlatform {
    
    private static final Logger logger = Logger.getLogger(TestPlatform.class.getName());
    private Platform platform;


    @BeforeEach
    public void createConfigurationForTestCases() {
        platform = new Platform();

        User.getUsers().clear();

        User user = new User("user1");
        user.setProfile(new Profile());
        user.getProfile().setUserId(UUID.fromString("fc4499e7-ada8-4728-a28a-63bfd02fe989"));
        user.register("user1@example.com", "password123");

        if (!User.getUsers().contains(user)) {
            User.getUsers().add(user);
        }
    }


    @Test
    @DisplayName("base: Profile is \"null\"")
    public void testProfile() {
        assertEquals(platform.getProfile(), null);
    }

    @Test
    @DisplayName("base: Match is \"null\"")
    public void testMatch() {
        assertEquals(platform.getMatch(), null);
    }

    @Test
    @DisplayName("set: Profile changes when set.")
    public void testProfileSet() {
        Profile profile = new Profile();
        platform.setProfile(profile);
        assertNotEquals(platform.getProfile(), null);
    }

    @Test
    @DisplayName("johnh9 test: Match changes when set.")
    public void testMatchSet() {
        User[] users = {null, null};
        Rules rules = new Rules();
        Match match = new Match(users, rules);
        platform.setMatch(match);
        assertNotEquals(platform.getMatch(), null);
    }

    @Test
    @DisplayName("logout: Profile is set to \"null\" when logout is called.")
    public void testLogout() {
        Profile profile = new Profile();
        platform.setProfile(profile);
        assertNotEquals(platform.getProfile(), null);

        platform.logout();
        assertEquals(platform.getMatch(), null);
    }

    @Test
    @DisplayName("johnh9 test: Login with valid credentials")
    public void testLoginValid() throws Exception{
        User loggedInUser = platform.login("user1@example.com", "password123");
        assertNotNull(loggedInUser);
        assertEquals("user1@example.com", loggedInUser.getEmail());
    }

    @Test
    @DisplayName("johnh9 test: Login with invalid credentials")
    public void testLoginInvalid() throws Exception{
        User loggedInUser = platform.login("user1@example.com", "wrongpassword");
        assertNull(loggedInUser);
    }

    @Test
    @DisplayName("johnh9 test: Set and get profile")
    public void testSetAndGetProfile() {
        Profile profile = new Profile();
        platform.setProfile(profile);
        assertEquals(profile, platform.getProfile());
    }

    @Test
    @DisplayName("johnh9 test: Set and get match")
    public void testSetAndGetMatch() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User[] users = {user1, user2};
        Rules rules = new Rules();
        Match match = new Match(users, rules);
        platform.setMatch(match);
        assertEquals(match, platform.getMatch());
    }

    @Test
    @DisplayName("johnh9 test: Login with multiple users")
    public void testLoginMultipleUsers() throws Exception{
        User user2 = new User("user2");
        user2.setProfile(new Profile());
        user2.register("user2@example.com", "password456");
        User.getUsers().add(user2);

        User loggedInUser1 = platform.login("user1@example.com", "password123");
        assertNotNull(loggedInUser1);
        assertEquals("user1@example.com", loggedInUser1.getEmail());

        User loggedInUser2 = platform.login("user2@example.com", "password456");
        assertNotNull(loggedInUser2);
        assertEquals("user2@example.com", loggedInUser2.getEmail());
    }
}