package com.tco.gameplaying;

import com.tco.gameplaying.Piece;
import com.tco.gameplaying.PieceType;
import com.tco.gameplaying.Color;

public class Knight extends Piece{
    public Knight(Color color, int[] position){
        super(PieceType.KNIGHT, color, position);
    }
}
