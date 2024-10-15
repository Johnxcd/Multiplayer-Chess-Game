package com.tco.gameplaying;

import com.tco.gameplaying.Piece;
import com.tco.gameplaying.PieceType;
import com.tco.gameplaying.Color;

public class Pawn extends Piece{
    public Pawn(Color color, int[] position){
        super(PieceType.PAWN, color, position);
    }
}
