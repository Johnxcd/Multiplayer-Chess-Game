package com.tco.gameplaying;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.tco.gameplaying.Piece;
import static org.junit.jupiter.api.Assertions.*;
import com.tco.gamemanagement.User;

public class TestGame {
    private Game game;
    private Rules rules;

    @BeforeEach
    public void setUp() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        rules = new Rules();
        game = new Match(new User[]{user1, user2}, rules);
    }

    @Test
    @DisplayName("johnh9 test: Test isPositionOnBoard")
    public void testIsPositionOnBoard() {
        int[] pos = {0, 0};
        assertTrue(game.isPositionOnBoard(pos));
        int[] invalidPos = {-1, 8};
        assertFalse(game.isPositionOnBoard(invalidPos));
    }
}
