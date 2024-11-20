package com.tco.usermanagement;
import com.tco.gameplaying.Match;
import com.tco.gameplaying.Rules;
import com.tco.gamemanagement.User;
import com.tco.gamemanagement.GameStatus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestHistory {

    private History history;
    private Match match;

    @BeforeEach
    public void createHistoryForTestCases() {
        history = new History();
        User user1 = new User("user1");
        User user2 = new User("user2");
        Rules rules = new Rules();
        match  = new Match(new User[]{user1, user2}, rules);
    }

    @Test
    @DisplayName("Dureke: New history should be empty")
    public void testHistoryRecord() {
        assertTrue(Arrays.equals(new int[]{0, 0, 0, 0, 0}, history.getRecord()));
    }

    @Test
    @DisplayName("Dureke: Adding a win match updates existing record")
    public void testAddingMatchWIN() {
        match.setStatus(GameStatus.WHITECHECKMATE);
        history.add(match, match.getUsers()[0].getUserName());

        assertTrue(Arrays.equals(new int[]{1, 0, 0, 0, 1}, history.getRecord()));
    }

    @Test
    @DisplayName("Dureke: Adding a LOSS match updates existing record")
    public void testAddingMatchLOSS() {
        match.setStatus(GameStatus.BLACKCHECKMATE); 

        history.add(match, match.getUsers()[0].getUserName());

        assertTrue(Arrays.equals(new int[]{0, 1, 0, 0, 1}, history.getRecord()));
    }

    @Test
    @DisplayName("Dureke: Adding a DRAW match updates existing record")
    public void testAddingMatchDRAW() {
        match.setStatus(GameStatus.DRAW);
        history.add(match, match.getUsers()[0].getUserName());

        assertTrue(Arrays.equals(new int[]{0, 0, 1, 0, 1}, history.getRecord()));
    }

    @Test
    @DisplayName("Dureke: Adding an ONGOING match updates existing record")
    public void testAddingMatchONGOING() {
        match.setStatus(GameStatus.ONGOING);
        history.add(match, match.getUsers()[0].getUserName());

        assertTrue(Arrays.equals(new int[]{0, 0, 0, 1, 1}, history.getRecord()));
    }

    @Test
    @DisplayName("Dureke: Adding an BLACKCHECK match updates existing record")
    public void testAddingMatchCHECKBLACK() {
        match.setStatus(GameStatus.BLACKCHECK);
        history.add(match, match.getUsers()[0].getUserName());

        assertTrue(Arrays.equals(new int[]{0, 0, 0, 1, 1}, history.getRecord()));
    }

    @Test
    @DisplayName("Dureke: Adding an WHITECHECK match updates existing record")
    public void testAddingMatchCHECKWHITE() {
        match.setStatus(GameStatus.WHITECHECK);
        history.add(match, match.getUsers()[0].getUserName());

        assertTrue(Arrays.equals(new int[]{0, 0, 0, 1, 1}, history.getRecord()));
    }

    @Test 
    @DisplayName("Dureke: removing a match from the history updates record")
    public void testUpdateHistory() {
        match.setStatus(GameStatus.DRAW);
        history.add(match, match.getUsers()[0].getUserName());
        assertTrue(Arrays.equals(new int[]{0, 0, 1, 0, 1}, history.getRecord()));
        history.remove(match, match.getUsers()[0].getUserName());
        assertTrue(Arrays.equals(new int[]{0, 0, 0, 0, 0}, history.getRecord()));
    }

    @Test 
    @DisplayName("Dureke: updating match record after status changed")
    public void testRecordStatusUpdate() {
        match.setStatus(GameStatus.ONGOING);
        history.add(match, match.getUsers()[0].getUserName());
        assertTrue(Arrays.equals(new int[]{0, 0, 0, 1, 1}, history.getRecord()));
        match.setStatus(GameStatus.DRAW);
        assertTrue(Arrays.equals(new int[]{0, 0, 1, 0, 1}, history.getRecord()));
    }

    @Test
    @DisplayName("Dureke: Ensure translate function outputs correct string")
    public void testTranslateStatus() {
        String user1 = match.getUsers()[0].getUserName();
        match.setStatus(GameStatus.WHITECHECKMATE);
        assertEquals("WIN", history.translateStatus(match, user1));

        match.setStatus(GameStatus.BLACKCHECKMATE);
        assertEquals("LOSS", history.translateStatus(match, user1));

        match.setStatus(GameStatus.DRAW);
        assertEquals("DRAW", history.translateStatus(match, user1));

        match.setStatus(GameStatus.ONGOING);
        assertEquals("ONGOING", history.translateStatus(match, user1));

        match.setStatus(GameStatus.BLACKCHECK);
        assertEquals("ONGOING", history.translateStatus(match, user1));

        match.setStatus(GameStatus.WHITECHECK);
        assertEquals("ONGOING", history.translateStatus(match, user1));
    }
}