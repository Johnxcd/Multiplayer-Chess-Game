package com.tco.gamemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.tco.gameplaying.Color;
import com.tco.gameplaying.Piece;
import com.tco.gameplaying.Rook;
import com.tco.gameplaying.Pawn;
import com.tco.gameplaying.Knight;
import com.tco.gameplaying.Rules;
import com.tco.gameplaying.Match;
import com.tco.gameplaying.PieceType;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Dureke: Test createBoard / new Match")
    public void testCreateBoard() {
        Piece exampleRook = new Rook(Color.WHITE, new int[]{0, 0});
        Piece actualPiece = game.getPieceAt(new int[]{0, 0});

        assertEquals(PieceType.ROOK, actualPiece.getType());
        assertEquals(exampleRook.getColor(), actualPiece.getColor());
    }

    @Test
    @DisplayName("Dureke: Test getUsers()")
    public void testGetUsers() {
        assertEquals(game.getUsers()[0].getUserName(), "user1");
    }

    @Test
    @DisplayName("Dureke: Test getBoard()")
    public void testGetBoard() {
        Piece[][] board = game.getBoard();

        assertEquals(PieceType.ROOK, board[0][0].getType());
        assertEquals(Color.WHITE, board[0][0].getColor());
    }

    // @Test
    // @DisplayName("userID: test sendNotification()")
    // public void testSendNotification() {
    //     User user3 = new User("user3");
    //     assertEquals(game.sendNotification(user3), null);
    // }
}
