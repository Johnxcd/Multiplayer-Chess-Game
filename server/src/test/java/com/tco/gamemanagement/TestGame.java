package com.tco.gamemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.tco.gameplaying.Piece;
import static org.junit.jupiter.api.Assertions.*;

public class TestGame {
    private Game game;

    private class GameTest extends Game {
        @Override
        public Piece getPieceAt(int[] position) {
            return null; // implement as needed for testing
        }

        @Override
        public boolean isPositionOnBoard(int[] position) {
            return position[0] >= 0 && position[0] < 8 && position[1] >= 0 && position[1] < 8;
        }
    }

    @BeforeEach
    public void setUp() {
        game = new GameTest();
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
