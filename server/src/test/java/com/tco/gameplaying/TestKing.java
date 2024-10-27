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

public class TestKing {
    private static final Logger logger = Logger.getLogger(TestKing.class.getName());

    private Game game;
    private King king;

    @BeforeEach
    public void setUp() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User[] users = {user1, user2};
        Rules rules = new Rules();
        game = new Match(users, rules);
    }

    @Test
    @DisplayName("johnh9 test: Test King Moves")
    public void testKingMoves() {
        king = new King(Color.WHITE, new int[]{4, 4});
        game.getBoard()[4][4] = king;  // put king in open space 
        logger.info("King position on the board: " + Arrays.toString(king.getPos()));

        List<int[]> possibleMoves = king.getPossibleMoves(game);
        logger.info("Number of moves generated: " + possibleMoves.size());
        for (int[] move : possibleMoves) {
            logger.info("Generated move: [" + move[0] + ", " + move[1] + "]");
        }

        List<int[]> expectedMoves = new ArrayList<>();
        // expected moves for a king at (4, 4)
        expectedMoves.add(new int[]{5, 4});
        expectedMoves.add(new int[]{3, 4});
        expectedMoves.add(new int[]{4, 5});
        expectedMoves.add(new int[]{4, 3});
        expectedMoves.add(new int[]{5, 5});
        expectedMoves.add(new int[]{5, 3});
        expectedMoves.add(new int[]{3, 5});
        expectedMoves.add(new int[]{3, 3});

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
