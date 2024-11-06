package com.tco.gamemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestInvitation {

    private Invitation invitation;

    @BeforeEach
    public void setup() {
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
    @DisplayName("Dureke test: Test Invite Message contents")
    public void testInviteMessage() {
        assertEquals(invitation.inviteMessage, "A player has invited you to a new game.");
    }

    @Test
    @DisplayName("Dureke test: Test Reject Message contents")
    public void testRejectMessage() {
        assertEquals(invitation.rejectedMessage, "A player has rejected an invitation.");
    }
}
