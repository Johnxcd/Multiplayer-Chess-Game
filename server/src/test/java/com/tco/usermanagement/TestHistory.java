package com.tco.usermanagement;
import com.tco.gameplaying.Match;
import com.tco.gameplaying.Rules;
import com.tco.gamemanagement.User;

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

    // setGameStatus needs to be updated in match.java for these tests to work

    // @Test
    // @DisplayName("Dureke: Adding a win match updates existing record")
    // public void testAddingMatch() {
    //     match.setGameStatus(GameStatus.CHECKMATE);
    //     history.add(match);

    //     assertTrue(Arrays.equals(new int[]{1, 0, 0, 0, 1}, history.getRecord()));
    // }

    // // TODO: ensure a loss for a specific user is reflected in their record 
    // @Test
    // @DisplayName("Dureke: Adding a LOSS match updates existing record")
    // public void testAddingMatch() {
    //     match.setGameStatus(GameStatus.CHECKMATE); 

    //     history.add(match);

    //     assertTrue(Arrays.equals(new int[]{0, 1, 0, 0, 1}, history.getRecord()));
    // }

    // @Test
    // @DisplayName("Dureke: Adding a DRAW match updates existing record")
    // public void testAddingMatch() {
    //     match.setGameStatus(GameStatus.DRAW);
    //     history.add(match);

    //     assertTrue(Arrays.equals(new int[]{0, 0, 1, 0, 1}, history.getRecord()));
    // }

    // @Test
    // @DisplayName("Dureke: Adding an ONGOING match updates existing record")
    // public void testAddingMatch() {
    //     match.setGameStatus(GameStatus.ONGOING);
    //     history.add(match);

    //     assertTrue(Arrays.equals(new int[]{0, 0, 0, 1, 1}, history.getRecord()));
    // }

    // @Test 
    // @DisplayName("Dureke: removing a match from the history updates record")
    // public void testUpdateHistory() {
    //     match.setGameStatus(GameStatus.DRAW);
    //     history.add(match);
    //     assertTrue(Arrays.equals(new int[]{0, 0, 1, 0, 1}, history.getRecord()));
    //     history.remove(match);
    //     assertTrue(Arrays.equals(new int[]{0, 0, 0, 0, 0}, history.getRecord()));
    // }

    // @Test 
    // @DisplayName("Dureke: updating match record without history knowing always reports accurately")
    // public void testUpdateHistory() {
    //     match.setGameStatus(GameStatus.ONGOING);
    //     history.add(match);
    //     assertTrue(Arrays.equals(new int[]{0, 0, 0, 1, 1}, history.getRecord()));
    //     match.setGameStatus(GameStatus.DRAW);
    //     assertTrue(Arrays.equals(new int[]{0, 0, 1, 0, 1}, history.getRecord()));
    // }
}