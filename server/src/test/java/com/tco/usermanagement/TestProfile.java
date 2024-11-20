package com.tco.usermanagement;
import com.tco.gamemanagement.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TestProfile {
    private Profile profile;

    @BeforeEach
    public void setUp() {
        profile = new Profile();
    }

    @Test
    @DisplayName("mattjon test: Profile data should relay data correctly")
    public void testProfileData() {
        History hist = new History();

        profile.setHistory(hist);
        
        String data = profile.getUserProfileData();

        String expectedResult = "";
        expectedResult += "Profile Creation Date: " + profile.getCreationDate() + "\n";
        expectedResult += "Wins: 0"  + "\n";
        expectedResult += "Losses: 0"  + "\n";
        expectedResult += "Draws: 0"  + "\n";
        expectedResult += "Ongoing: 0"  + "\n";

        assertEquals(data, expectedResult);
    }
}
