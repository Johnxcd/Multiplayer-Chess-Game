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
        Piece pawn = null;
        try{
        pawn = PieceFactory.createPiece(PieceType.PAWN, Color.WHITE, position);
        }
        catch(Exception IllegalPieceException){
            
        }
        assertEquals(PieceType.PAWN, pawn.getType());
        assertEquals(Color.WHITE, pawn.getColor());
        assertEquals(position, pawn.getPos());
    }

    @Test
    @DisplayName("sam25:  test king return from factory")
    public void testCreateKing(){
        int[] position = {1, 1};
        Piece king = null;
        try{
        king = PieceFactory.createPiece(PieceType.KING, Color.BLACK, position);
        }
        catch(Exception IllegalPieceException){

        }
        assertEquals(PieceType.KING, king.getType());
        assertEquals(Color.BLACK, king.getColor());
        assertEquals(position, king.getPos());
    }

    @Test
    @DisplayName("sam25:  test queen return from factory")
    public void testCreateQueen(){
        int[] position = {1, 1};
        Piece queen = null;
        try{
        queen = PieceFactory.createPiece(PieceType.QUEEN, Color.WHITE, position);
        }
        catch(Exception IllegalPieceException){
            
        }
        assertEquals(PieceType.QUEEN, queen.getType());
        assertEquals(Color.WHITE, queen.getColor());
        assertEquals(position, queen.getPos());
    }

    @Test
    @DisplayName("sam25:  test rook return from factory")
    public void testCreateRook(){
        int[] position = {1, 1};
        Piece rook = null;

        try{
        rook = PieceFactory.createPiece(PieceType.ROOK, Color.WHITE, position);
        }
        catch(Exception IllegalPieceException){
            
        }
        assertEquals(PieceType.ROOK, rook.getType());
        assertEquals(Color.WHITE, rook.getColor());
        assertEquals(position, rook.getPos());
    }

    @Test
    @DisplayName("sam25:  test bishop return from factory")
    public void testCreateBishop(){
        int[] position = {1, 1};
        Piece bishop = null;
        try{
        bishop = PieceFactory.createPiece(PieceType.BISHOP, Color.WHITE, position);
        }
        catch(Exception IllegalPieceException){
            
        }
        assertEquals(PieceType.BISHOP, bishop.getType());
        assertEquals(Color.WHITE, bishop.getColor());
        assertEquals(position, bishop.getPos());
    }

    @Test
    @DisplayName("sam25:  test knight return from factory")
    public void testCreateKnight(){
        int[] position = {1, 1};
        Piece knight = null;
        try{
        knight = PieceFactory.createPiece(PieceType.KNIGHT, Color.WHITE, position);
        }
        catch(Exception IllegalPieceException){
            
        }
        assertEquals(PieceType.KNIGHT, knight.getType());
        assertEquals(Color.WHITE, knight.getColor());
        assertEquals(position, knight.getPos());
    }
}
