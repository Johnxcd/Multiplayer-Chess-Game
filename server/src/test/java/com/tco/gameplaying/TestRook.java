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

public class TestRook {
    private static final Logger logger = Logger.getLogger(TestRook.class.getName());

    private Game game;
    private Rook rook;

    @BeforeEach
    public void setUp() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User[] users = {user1, user2};
        Rules rules = new Rules();
        game = new Match(users, rules);
        rook = new Rook(Color.WHITE, new int[]{4, 4});
        game.getBoard()[4][4] = rook;  // rook in an open space
        logger.info("Rook position on the board: " + Arrays.toString(rook.getPos()));
    }

    @Test
    @DisplayName("johnh9 test: Test Rook Moves")
    public void testRookMoves() {
        List<int[]> possibleMoves = rook.getPossibleMoves(game);
        logger.info("Number of moves generated: " + possibleMoves.size());
        for (int[] move : possibleMoves) {
            logger.info("Generated move: [" + move[0] + ", " + move[1] + "]");
        }

        List<int[]> expectedMoves = new ArrayList<>();
        // expected moves for a rook at position (4, 4)
        expectedMoves.add(new int[]{5, 4});  // down first empty square
        expectedMoves.add(new int[]{6, 4});  // down capture move
        expectedMoves.add(new int[]{3, 4});  // up first empty square
        expectedMoves.add(new int[]{2, 4});  // up second empty square
        expectedMoves.add(new int[]{4, 5});  // right first empty square
        expectedMoves.add(new int[]{4, 6});  // right second empty square
        expectedMoves.add(new int[]{4, 7});  // right third empty square
        expectedMoves.add(new int[]{4, 3});  // left first empty square
        expectedMoves.add(new int[]{4, 2});  // left second empty square
        expectedMoves.add(new int[]{4, 1});  // left third empty square
        expectedMoves.add(new int[]{4, 0});  // left fourth empty square

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
