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

public class TestPawn {
    private static final Logger logger = Logger.getLogger(TestPawn.class.getName());

    private Game game;
    private Pawn pawn;

    @BeforeEach
    public void setUp() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User[] users = {user1, user2};
        Rules rules = new Rules();
        game = new Match(users, rules);
    }

    @Test
    @DisplayName("johnh9 test: Test Pawn Moves Forward")
    public void testPawnMovesForward() {
        pawn = new Pawn(Color.WHITE, new int[]{4, 4});
        game.getBoard()[4][4] = pawn;  // place the pawn in an open space
        logger.info("Pawn position on the board: " + Arrays.toString(pawn.getPos()));

        List<int[]> possibleMoves = pawn.getPossibleMoves(game);
        logger.info("Number of moves generated: " + possibleMoves.size());
        for (int[] move : possibleMoves) {
            logger.info("Generated move: [" + move[0] + ", " + move[1] + "]");
        }

        List<int[]> expectedMoves = new ArrayList<>();
        expectedMoves.add(new int[]{5, 4});  // forward

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

    @Test
    @DisplayName("johnh9 test: Test Pawn Captures Diagonally")
    public void testPawnCapturesDiagonally() {
        pawn = new Pawn(Color.WHITE, new int[]{4, 4});
        game.getBoard()[4][4] = pawn;  // place the pawn in an open space
        game.getBoard()[5][3] = new Pawn(Color.BLACK, new int[]{5, 3});  // 2 opponent pawns for capture
        game.getBoard()[5][5] = new Pawn(Color.BLACK, new int[]{5, 5});  
        logger.info("Pawn position on the board: " + Arrays.toString(pawn.getPos()));

        List<int[]> possibleMoves = pawn.getPossibleMoves(game);
        logger.info("Number of moves generated: " + possibleMoves.size());
        for (int[] move : possibleMoves) {
            logger.info("Generated move: [" + move[0] + ", " + move[1] + "]");
        }

        List<int[]> expectedMoves = new ArrayList<>();
        expectedMoves.add(new int[]{5, 4});  // forward
        expectedMoves.add(new int[]{5, 3});  // left diagonal capture
        expectedMoves.add(new int[]{5, 5});  // right diagonal capture

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
