package com.tco.gameplaying;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class TestPiece {
    
    public Class PieceTest extends Piece{
    }
    
    private PieceTest piece;

    @BeforeEach
    public void setUp() {
        int[] position = {0,0};
        piece = new Piece("King", "White", position);
    }

    @Test
    @DisplayName("ept: Piece can be created")
    public void testPieceName() {
        int[] position = {0,0};
        assertEquals("King", piece.getName());
        assertEquals("White", piece.getColor());
        assertEquals(0, piece.getPos()[0]);
    }
}
