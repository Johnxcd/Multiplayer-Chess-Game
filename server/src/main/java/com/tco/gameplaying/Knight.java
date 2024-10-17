package com.tco.gameplaying;

import java.util.List;
import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(Color color, int[] position){
        super(PieceType.KNIGHT, color, position);
    }

    @Override
    public List<int[]> getPossibleMoves(Game game) {
        return new ArrayList<>(); // placeholder for knight's possible moves
    }
}
