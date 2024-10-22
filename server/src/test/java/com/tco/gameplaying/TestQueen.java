package com.tco.gameplaying;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import com.tco.gamemanagement.Game;
import com.tco.gamemanagement.User;
import com.tco.gameplaying.Rules;
import com.tco.gameplaying.Match;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class TestQueen {
    private static final Logger logger = Logger.getLogger(TestQueen.class.getName());

    private Game game;
    private Queen queen;

    @BeforeEach
    public void setUp() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User[] users = {user1, user2};
        Rules rules = new Rules();
        game = new Match(users, rules);
    }

    @Test
    @DisplayName("johnh9 test: Test Queen Moves")
    public void testQueenMoves() {
        queen = new Queen(Color.WHITE, new int[]{4, 4});
        // place queen in open space, place pawns for capture
        game.getBoard()[4][4] = queen;  
        game.getBoard()[6][4] = new Pawn(Color.BLACK, new int[]{6, 4});  
        game.getBoard()[1][4] = new Pawn(Color.BLACK, new int[]{1, 4});
        game.getBoard()[6][6] = new Pawn(Color.BLACK, new int[]{6, 6});
        game.getBoard()[6][2] = new Pawn(Color.BLACK, new int[]{6, 2});
        game.getBoard()[1][7] = new Pawn(Color.BLACK, new int[]{1, 7});
        game.getBoard()[1][1] = new Pawn(Color.BLACK, new int[]{1, 1});
        logger.info("Queen position on the board: " + Arrays.toString(queen.getPos()));

        List<int[]> possibleMoves = queen.getPossibleMoves(game);
        logger.info("Number of moves generated: " + possibleMoves.size());
        for (int[] move : possibleMoves) {
            logger.info("Generated move: [" + move[0] + ", " + move[1] + "]");
        }

        List<int[]> expectedMoves = new ArrayList<>();
        // expected moves queen at (4, 4), considering blocking pieces
        // up down left right moves
        expectedMoves.add(new int[]{5, 4});
        expectedMoves.add(new int[]{6, 4});  // Capture 
        expectedMoves.add(new int[]{3, 4});
        expectedMoves.add(new int[]{2, 4});
        expectedMoves.add(new int[]{1, 4});  // Capture
        expectedMoves.add(new int[]{4, 5});
        expectedMoves.add(new int[]{4, 6});
        expectedMoves.add(new int[]{4, 7});
        expectedMoves.add(new int[]{4, 3});
        expectedMoves.add(new int[]{4, 2});
        expectedMoves.add(new int[]{4, 1});
        expectedMoves.add(new int[]{4, 0});
        // diagonal moves
        expectedMoves.add(new int[]{5, 5});
        expectedMoves.add(new int[]{6, 6});  // Capture
        expectedMoves.add(new int[]{5, 3});
        expectedMoves.add(new int[]{6, 2});  // Capture
        expectedMoves.add(new int[]{3, 5});
        expectedMoves.add(new int[]{2, 6});
        expectedMoves.add(new int[]{1, 7});  // Capture
        expectedMoves.add(new int[]{3, 3});
        expectedMoves.add(new int[]{2, 2});
        expectedMoves.add(new int[]{1, 1});  // Capture

        logger.info("Expected moves:");
        for (int[] move : expectedMoves) {
            logger.info("Expected move: [" + move[0] + ", " + move[1] + "]");
        }

        assertEquals(expectedMoves.size(), possibleMoves.size(), "Number of possible moves should match");
        for (int[] move : expectedMoves) {
            boolean found = false;
            for (int[] generatedMove : possibleMoves) {
                if (Arrays.equals(move, generatedMove)) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "Expected move not found: [" + move[0] + ", " + move[1] + "]");
        }
    }
}
