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

public class TestKnight {
    private static final Logger logger = Logger.getLogger(TestKnight.class.getName());

    private Game game;
    private Knight knight;

    @BeforeEach
    public void setUp() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User[] users = {user1, user2};
        Rules rules = new Rules();
        game = new Match(users, rules);
    }

    @Test
    @DisplayName("johnh9 test: Test Knight Moves")
    public void testKnightMoves() {
        knight = new Knight(Color.WHITE, new int[]{4, 4});
        game.getBoard()[4][4] = knight;  // place knight in open space
        logger.info("Knight position on the board: " + Arrays.toString(knight.getPos()));

        List<int[]> possibleMoves = knight.getPossibleMoves(game);
        logger.info("Number of moves generated: " + possibleMoves.size());
        for (int[] move : possibleMoves) {
            logger.info("Generated move: [" + move[0] + ", " + move[1] + "]");
        }

        List<int[]> expectedMoves = new ArrayList<>();
        // expected moves for knight at (4, 4)
        expectedMoves.add(new int[]{6, 5});
        expectedMoves.add(new int[]{6, 3});
        expectedMoves.add(new int[]{2, 5});
        expectedMoves.add(new int[]{2, 3});
        expectedMoves.add(new int[]{5, 6});
        expectedMoves.add(new int[]{5, 2});
        expectedMoves.add(new int[]{3, 6});
        expectedMoves.add(new int[]{3, 2});

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
