package com.tco.gameplaying;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import com.tco.gamemanagement.User;
import com.tco.gameplaying.Rules;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestMatch {

    private Match match;

    @BeforeEach
    public void setUp() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User[] users = {user1, user2};
        Rules rules = new Rules();
        match = new Match(users, rules);
    }

    @Test
    @DisplayName("johnh9 test: Test Match Creation")
    public void testMatchCreation() {
        assertNotNull(match);
    }

    @Test
    @DisplayName("Dureke test: Test capture Piece method") 
    public void testCapturePiece() {
        Piece startPiece = match.getPieceAt(new int[] {0, 0});
        Piece endPiece = match.getPieceAt(new int[] {0, 1});

        assertEquals(startPiece.getType(), PieceType.ROOK);
        assertEquals(endPiece.getType(), PieceType.KNIGHT);
        
        match.capturePiece(startPiece.getPos(), endPiece.getPos(), null);

        assertNull(match.getPieceAt(new int[] {0, 0}));
        assertEquals(match.getPieceAt(new int[] {0, 1}).getType(), PieceType.ROOK);
    }

    @Test
    @DisplayName("Dureke test: Test capture Piece method, en Passant exception") 
    public void testCapturePieceEnPassant() {
        Piece startPiece = match.getPieceAt(new int[] {0, 0});
        Piece midPiece = match.getPieceAt(new int[] {0, 1});
        Piece endPiece = match.getPieceAt(new int[] {0, 2});

        assertEquals(startPiece.getType(), PieceType.ROOK);
        assertEquals(midPiece.getType(), PieceType.KNIGHT);
        assertEquals(endPiece.getType(), PieceType.BISHOP);
        
        match.capturePiece(startPiece.getPos(), new int[] {0, 2}, midPiece.getPos());

        assertNull(match.getPieceAt(new int[] {0, 0}));
        assertNull(match.getPieceAt(new int[] {0, 1}));
        assertEquals(match.getPieceAt(new int[] {0, 2}).getType(), PieceType.ROOK);
    }
}
