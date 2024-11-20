package com.tco.gamemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.tco.usermanagement.Profile;
import com.tco.gameplaying.Match;
import com.tco.gameplaying.Rules;
import java.util.List;
import java.util.ArrayList;
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
        User[] users = {user1, user2};
        Rules rules = new Rules();
        match = new Match(users, rules);
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
            public void acceptInvitation(Invitation invitation) {
                // Implementation for test
            }

            @Override
            public void rejectInvitation(Invitation invitation) {
                // Implementation for test
            }

            @Override
            public void notifyAllPlayers() {
                // Implementation for test
            }
        };
    }

    @Test
    @DisplayName("johnh9 test: Test user registration")
    public void testRegister() {
        user1.register("user1@example.com", "password123");
        assertEquals("user1", user1.getUserName());
    }

    @Test
    @DisplayName("johnh9 test: Test user authentication")
    public void testAuthenticate() {
        user1.register("user1@example.com", "password123");
        assertNotNull(user1.authenticate("user1@example.com", "password123"));
    }

    @Test
    @DisplayName("Test viewing profile")
    public void testViewProfile() {
        user1.viewProfile();
        // Implementation for test
    }

    @Test
    @DisplayName("johnh9 test: Test updating profile")
    public void testUpdateProfile() {
        user1.updateProfile(profile);
        assertEquals(profile, user1.getProfile());
    }

    @Test
    @DisplayName("johnh9 test: Test accepting invitation")
    public void testAcceptInvitation() {
        user1.acceptInvitation(invitation);
        assertTrue(user1.getInvitations().contains(invitation));
    }

    @Test
    @DisplayName("Test rejecting invitation")
    public void testRejectInvitation() {
        user1.rejectInvitation(invitation);
        // Implementation for test
    }

    @Test
    @DisplayName("johnh9 test: Test joining match")
    public void testJoinMatch() {
        user1.joinMatch(match);
        assertTrue(user1.getMatches().contains(match));
    }

    @Test
    @DisplayName("johnh9 test: Test quitting match")
    public void testQuitMatch() {
        user1.joinMatch(match);
        user1.quitMatch(match);
        assertFalse(user1.getMatches().contains(match));
    }
    
    @Test
    @DisplayName("johnh9 test: Test getUsers")
    public void testGetUsers() {
        List<User> users = User.getUsers();
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
    }

    @Test
    @DisplayName("johnh9 test: Test getInvitations")
    public void testGetInvitations() {
        user1.acceptInvitation(invitation);
        List<Invitation> invitations = user1.getInvitations();
        assertTrue(invitations.contains(invitation));
    }

    @Test
    @DisplayName("johnh9 test: Test getMatches")
    public void testGetMatches() {
        user1.joinMatch(match);
        List<Match> matches = user1.getMatches();
        assertTrue(matches.contains(match));
    }
}
