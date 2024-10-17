package com.tco.gameplaying;

import com.tco.gameplaying.Piece;
import com.tco.gameplaying.PieceType;
import com.tco.gameplaying.Color;
import java.util.List;
import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(Color color, int[] position){
        super(PieceType.BISHOP, color, position);
    }
    
    @Override
    public List<int[]> getPossibleMoves(Game game) {
        return new ArrayList<>(); // Placeholder for bishop's possible moves
    }
}
