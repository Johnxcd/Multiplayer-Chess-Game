package com.tco.gamemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tco.usermanagement.Profile;
import com.tco.gameplaying.Match;
import static org.junit.jupiter.api.Assertions.*;

public class TestUser {

    private User user1;
    private User user2;
    private Profile profile;
    private Match match;
    private Invitation invitation;

    @BeforeEach
    public void setUp() {
        user1 = new User("user1");
        user2 = new User("user2");
        profile = new Profile();
        match = new Match();
        invitation = new Invitation() {
            @Override
            public void sendNotification(User user) {
                // Implementation for test
            }

            @Override
            public void onInvitation() {
                // Implementation for test
            }

            @Override
            public void notifyAllPlayers() {
                // Implementation for test
            }
        };
    }

    @Test
    public void testRegister() {
        user1.register("user1@example.com", "password123");
        assertEquals("user1", user1.getUsername());
    }

    @Test
    public void testAuthenticate() {
        user1.register("user1@example.com", "password123");
        assertNotNull(user1.authenticate("user1@example.com", "password123"));
    }

    @Test
    public void testViewProfile() {
        user1.viewProfile();
        // Ensure that profile view logic is tested
    }

    @Test
    public void testUpdateProfile() {
        user1.updateProfile(profile);
        assertEquals(profile, user1.getProfile());
    }

    @Test
    public void testAcceptInvitation() {
        user1.acceptInvitation(invitation);
        assertTrue(user1.getInvitations().contains(invitation));
    }

    @Test
    public void testRejectInvitation() {
        user1.rejectInvitation(invitation);
        // Logic for testing invitation rejection
    }

    @Test
    public void testJoinMatch() {
        user1.joinMatch(match);
        assertTrue(user1.getMatches().contains(match));
    }

    @Test
    public void testQuitMatch() {
        user1.joinMatch(match);
        user1.quitMatch(match);
        assertFalse(user1.getMatches().contains(match));
    }
}
