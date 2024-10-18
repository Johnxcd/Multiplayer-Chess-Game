package com.tco.gameplaying;

import java.util.List;
import java.util.ArrayList;
import com.tco.gamemanagement.Game;

public class King extends Piece{
    public King(Color color, int[] position){
        super(PieceType.KING, color, position);
    }

    @Override
    public List<int[]> getPossibleMoves(Game game) {
        return new ArrayList<>(); // placeholder for king's possible moves
    }
    
}
