package com.tco.gameplaying;

import com.tco.gameplaying.Color;
import com.tco.gameplaying.PieceType;
import com.tco.gamemanagement.Game;
import java.util.List;

public abstract class Piece{
    private PieceType type;
    private Color color;
    private int[] position;

    public Piece(PieceType type, Color color, int[] position) {
        this.type = type;
        this.color = color;
        this.position = position;
    }

    public PieceType getType() {
        return this.type;
    }

    public Color getColor() {
        return this.color;
    }

    public int[] getPos() {
        return this.position;
    }

    public void setPos(int[] position) {
        this.position = position;
    }

    // abstract method for possible moves
    public abstract List<int[]> getPossibleMoves(Game game);
}
