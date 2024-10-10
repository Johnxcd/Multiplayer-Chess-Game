package com.tco.gamemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TestNotification{
    private Notification notify;

    public class NotifyTest implements Notification{
        boolean recieved = false;
        @Override
        public void notifyAllPlayers(){
            recieved = true;
        }
        public boolean getRecieved(){
            return recieved;
        }
    }

    @Test
    public void TestNotifyAll(){
        NotifyTest notifyTest1 = new NotifyTest();
        NotifyTest notifyTest2 = new NotifyTest();
        NotifyTest notifyTest3 = new NotifyTest();

        notifyTest1.notifyAllPlayers();

        assertTrue(notifyTest1.getRecieved());
        assertTrue(notifyTest2.getRecieved());
        assertTrue(notifyTest3.getRecieved());
    }
}
