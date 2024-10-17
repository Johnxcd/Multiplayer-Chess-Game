package com.tco.gameplaying;

import java.util.List;
import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(Color color, int[] position){
        super(PieceType.QUEEN, color, position);
    }

    @Override
    public List<int[]> getPossibleMoves(Game game) {
        return new ArrayList<>(); // placeholder for queen's possible moves
    }
}
