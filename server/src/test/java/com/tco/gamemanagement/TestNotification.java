package com.tco.gamemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TestNotification{
    private Notification notify;

    public class NotifyTest implements Notification{
        boolean recieved = false;

        private static List<User> users = new ArrayList<>();
        private String username;
        
        public NotifyTest(String username) {
            this.username = username;
            users.add(this);
          }
      
        public String getUsername() {
            return username;
        }
      
        public static void sendInvitation(String username) {
            
        }

        @Override
        public void notifyAllPlayers(){
            for (User user : users) {
                recieved = true;
            }
        }
        public boolean getRecieved(){
            return recieved;
        }
    }

    @Test
    public void TestNotifyAll(){
        NotifyTest notifyTest1 = new NotifyTest("A");
        NotifyTest notifyTest2 = new NotifyTest("B");
        NotifyTest notifyTest3 = new NotifyTest("C");

        notifyTest1.notifyAllPlayers();

        assertTrue(notifyTest1.getRecieved());
        assertTrue(notifyTest2.getRecieved());
        assertTrue(notifyTest3.getRecieved());
    }
}
