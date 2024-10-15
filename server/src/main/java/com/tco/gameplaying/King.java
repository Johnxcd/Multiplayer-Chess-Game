package com.tco.gameplaying;

import com.tco.gameplaying.Piece;
import com.tco.gameplaying.PieceType;
import com.tco.gameplaying.Color;

public class King extends Piece{
    public King(Color color, int[] position){
        super(PieceType.KING, color, position);
    }
}
