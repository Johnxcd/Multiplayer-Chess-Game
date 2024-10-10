package com.tco.gamemanagement;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestNotification {
    public static class NotifyTest implements Notification {
        boolean received = false;
        private static List<NotifyTest> users = new ArrayList<>();
        private String username;

        public NotifyTest(String username) {
            this.username = username;
            users.add(this);
        }

        public String getUsername() {
            return username;
        }

        public static void sendInvitation(String username) {
            // Implementation can be added here
        }

        @Override
        public void notifyAllPlayers() {
            for (NotifyTest user : users) {
                user.received = true;
            }
        }

        public boolean getReceived() {
            return received;
        }
    }

    @Test
    public void testNotifyAll() {
        NotifyTest notifyTest1 = new NotifyTest("A");
        NotifyTest notifyTest2 = new NotifyTest("B");
        NotifyTest notifyTest3 = new NotifyTest("C");

        notifyTest1.notifyAllPlayers();

        assertTrue(notifyTest1.getReceived());
        assertTrue(notifyTest2.getReceived());
        assertTrue(notifyTest3.getReceived());
    }
}
