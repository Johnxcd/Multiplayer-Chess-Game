package com.tco.gamemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestInvitation {
  
    private static final transient Logger log = LoggerFactory.getLogger(TestInvitation.class);
    boolean testIsMe = false;

    public class InviteTest implements Invitation{
        String userName = null;
        public InviteTest(String userName){
            this.userName = userName;
        }

        @Override
        public void notifyAllPlayers(){
            
        }

        @Override
        public void sendNotification(User user){

        }

        @Override
        public void onInvitation(String userName){
            if(this.userName == userName){
                testIsMe = true;
            }
        }
    }

    @BeforeEach
    public void setUp() {
        // invitation = new InviteTest();
    }

    @Test
    public void testOnInviteValid(){
        InviteTest inviteTest = new InviteTest("UserOne");

        inviteTest.onInvitation("UserOne");

    }
}
