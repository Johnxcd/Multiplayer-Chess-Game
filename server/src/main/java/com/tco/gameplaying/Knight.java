package com.tco.gameplaying;

import com.tco.gameplaying.Piece;
import com.tco.gameplaying.PieceType;
import com.tco.gameplaying.Color;
import java.util.List;
import java.util.ArrayList;
import com.tco.gamemanagement.Game;

public class Knight extends Piece{
    public Knight(Color color, int[] position){
        super(PieceType.KNIGHT, color, position);
    }

    @Override
    public List<int[]> getPossibleMoves(Game game) {
        return new ArrayList<>(); // placeholder for knight's possible moves
    }
}
