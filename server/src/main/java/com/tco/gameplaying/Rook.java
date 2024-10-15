package com.tco.gameplaying;

import com.tco.gameplaying.Piece;
import com.tco.gameplaying.PieceType;
import com.tco.gameplaying.Color;

public class Rook extends Piece{
    public Rook(Color color, int[] position){
        super(PieceType.ROOK, color, position);
    }
}
