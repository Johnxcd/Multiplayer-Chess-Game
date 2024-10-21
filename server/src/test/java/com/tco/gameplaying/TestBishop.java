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

public class TestBishop {
    private static final Logger logger = Logger.getLogger(TestBishop.class.getName());

    private Game game;
    private Bishop bishop;

    @BeforeEach
    public void setUp() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User[] users = {user1, user2};
        Rules rules = new Rules();
        game = new Match(users, rules);
    }

    @Test
    @DisplayName("johnh9 test: Test Bishop Moves")
    public void testBishopMoves() {
        bishop = new Bishop(Color.WHITE, new int[]{4, 4});
        game.getBoard()[4][4] = bishop;  // place the bishop in an open space
        game.getBoard()[6][6] = new Pawn(Color.BLACK, new int[]{6, 6});  // place opponents pawns for capture
        game.getBoard()[6][2] = new Pawn(Color.BLACK, new int[]{6, 2});  
        game.getBoard()[1][7] = new Pawn(Color.BLACK, new int[]{1, 7});  
        game.getBoard()[1][1] = new Pawn(Color.BLACK, new int[]{1, 1});  
        logger.info("Bishop position on the board: " + Arrays.toString(bishop.getPos()));

        List<int[]> possibleMoves = bishop.getPossibleMoves(game);
        logger.info("Number of moves generated: " + possibleMoves.size());
        for (int[] move : possibleMoves) {
            logger.info("Generated move: [" + move[0] + ", " + move[1] + "]");
        }

        List<int[]> expectedMoves = new ArrayList<>();
        // expected moves for a bishop at position (4, 4)
        expectedMoves.add(new int[]{5, 5});  // down-right
        expectedMoves.add(new int[]{6, 6});  // down-right capture
        expectedMoves.add(new int[]{5, 3});  // down-left
        expectedMoves.add(new int[]{6, 2});  // down-left capture
        expectedMoves.add(new int[]{3, 5});  // up-right
        expectedMoves.add(new int[]{2, 6});  // up-right
        expectedMoves.add(new int[]{1, 7});  // up-right capture
        expectedMoves.add(new int[]{3, 3});  // up-left
        expectedMoves.add(new int[]{2, 2});  // up-left
        expectedMoves.add(new int[]{1, 1});  // up-left capture

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
