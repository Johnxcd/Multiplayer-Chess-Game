package com.tco.gameplaying;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class TestPiece {
    
    public class PieceTest extends Piece{
        
        public PieceTest(PieceType type, Color color, int[] pos){
            super(type,color,pos);
        }
    }
    
    private PieceTest piece;

    @BeforeEach
    public void setUp() {
        int[] position = {0,0};
        piece = new PieceTest(PieceType.KING, Color.WHITE, position);
    }

    @Test
    @DisplayName("ept: Piece can be created")
    public void testPieceName() {
        int[] position = {0,0};
        assertEquals(PieceType.KING, piece.getType());
        assertEquals(Color.WHITE, piece.getColor());
        assertEquals(0, piece.getPos()[0]);
    }
}
