package com.tco.misc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestHistory {

    private History history;

    @BeforeEach
    public void createHistoryForTestCases() {
        history = new History();
    }

    @Test
    @DisplayName("base: New history should be empty")
    public void testHistoryRecord() {
        assertTrue(Arrays.equals(new int[]{0, 0, 0, 0}, history.getRecord()));
    }

    // @Test
    // @DisplayName("base: Adding a match updates existing record")
    // public void testAddingMatch() {
    //     Match match = new Match();
    //     match.setGameStatus("Loss");

    //     assertTrue(Arrays.equals(new int[]{0, 1, 0, 0}, history.getRecord()));
    // }

    // @Test 
    // @DisplayName("base: calling update history will incorrect action should not update the record")
    // public void testUpdateHistory() {
    //     Match match = new Match();
    //     match.setGameStatus("Loss");
    //     history.updateHistory(match, "wrong");
    //     assertFalse(Arrays.equals(new int[]{0, 1, 0, 0}, history.getRecord()));
    // }
}