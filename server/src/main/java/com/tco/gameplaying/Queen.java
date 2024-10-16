package com.tco.gameplaying;

import com.tco.gameplaying.Piece;
import com.tco.gameplaying.PieceType;
import com.tco.gameplaying.Color;
import java.util.List;
import java.util.ArrayList;
import com.tco.gamemanagement.Game;

public class Queen extends Piece{
    public Queen(Color color, int[] position){
        super(PieceType.QUEEN, color, position);
    }

    @Override
    public List<int[]> getPossibleMoves(Game game) {
        return new ArrayList<>(); // placeholder for queen's possible moves
    }
}
