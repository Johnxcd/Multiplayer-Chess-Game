package com.tco.gameplaying;

import com.tco.gameplaying.Piece;
import com.tco.gameplaying.PieceType;
import com.tco.gameplaying.Color;
import java.util.List;
import java.util.ArrayList;
import com.tco.gamemanagement.Game;

public class Rook extends Piece{
    public Rook(Color color, int[] position){
        super(PieceType.ROOK, color, position);
    }
    
    @Override
    public List<int[]> getPossibleMoves(Game game) {
        return new ArrayList<>(); // Placeholder for rook's possible moves
    }
}
