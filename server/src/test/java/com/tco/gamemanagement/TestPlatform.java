package com.tco.gamemanagement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import com.tco.usermanagement.Profile;
import com.tco.usermanagement.History;
import com.tco.gameplaying.Match;
import com.tco.gameplaying.Rules;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestPlatform {

    private Platform platform;

    @BeforeEach
    public void createConfigurationForTestCases() {
        platform = new Platform();
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
        List<User> users = new ArrayList<>();
        Rules rules = new Rules();
        History history = new History();
        Match match = new Match(users, history, rules);
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
}