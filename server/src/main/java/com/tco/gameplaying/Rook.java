package com.tco.gameplaying;

import java.util.List;
import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(Color color, int[] position){
        super(PieceType.ROOK, color, position);
    }
    
    @Override
    public List<int[]> getPossibleMoves(Game game) {
        return new ArrayList<>(); // Placeholder for rook's possible moves
    }
}
