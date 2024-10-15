package com.tco.gameplaying;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import com.tco.gameplaying.PieceFactory;
import com.tco.gameplaying.Piece;
import com.tco.gameplaying.Rook;
import com.tco.gameplaying.King;
import com.tco.gameplaying.Queen;
import com.tco.gameplaying.Pawn;
import com.tco.gameplaying.Bishop;
import com.tco.gameplaying.Knight;
import com.tco.gameplaying.PieceFactory;

public class TestPieceFactory {
    
    @Test
    @DisplayName("sam25:  test pawn return from factory")
    public void testCreatePawn(){
        int[] position = {1, 1};
        Piece pawn = PieceFactory.createPiece(PieceType.PAWN, Color.WHITE, position)
        
        assertEquals(PieceType.PAWN, pawn.getType);
        assertEquals(Color.WHITE, pawn.getColor);
        assertEquals({1, 1}, pawn.getPos);
    }

    @Test
    @DisplayName("sam25:  test king return from factory")
    public void testCreatePawn(){
        int[] position = {1, 1};
        Piece king = PieceFactory.createPiece(PieceType.KING, Color.BLACK, position)
        
        assertEquals(PieceType.KING, king.getType);
        assertEquals(Color.BLACK, king.getColor);
        assertEquals({1, 1}, king.getPos);
    }

    @Test
    @DisplayName("sam25:  test queen return from factory")
    public void testCreatePawn(){
        int[] position = {1, 1};
        Piece queen = PieceFactory.createPiece(PieceType.QUEEN, Color.WHITE, position)
        
        assertEquals(PieceType.QUEEN, queen.getType);
        assertEquals(Color.WHITE, queen.getColor);
        assertEquals({1, 1}, queen.getPos);
    }

    @Test
    @DisplayName("sam25:  test rook return from factory")
    public void testCreatePawn(){
        int[] position = {1, 1};
        Piece rook = PieceFactory.createPiece(PieceType.ROOK, Color.WHITE, position)
        
        assertEquals(PieceType.ROOK, rook.getType);
        assertEquals(Color.WHITE, rook.getColor);
        assertEquals({1, 1}, rook.getPos);
    }

    @Test
    @DisplayName("sam25:  test bishop return from factory")
    public void testCreatePawn(){
        int[] position = {1, 1};
        Piece bishop = PieceFactory.createPiece(PieceType.BISHOP, Color.WHITE, position)
        
        assertEquals(PieceType.BISHOP, bishop.getType);
        assertEquals(Color.WHITE, bishop.getColor);
        assertEquals({1, 1}, bishop.getPos);
    }

    @Test
    @DisplayName("sam25:  test knight return from factory")
    public void testCreatePawn(){
        int[] position = {1, 1};
        Piece knight = PieceFactory.createPiece(PieceType.KNIGHT, Color.WHITE, position)
        
        assertEquals(PieceType.KNIGHT, knight.getType);
        assertEquals(Color.WHITE, knight.getColor);
        assertEquals({1, 1}, knight.getPos);
    }
}
