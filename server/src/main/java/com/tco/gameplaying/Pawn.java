package com.tco.gameplaying;

import java.util.List;
import java.util.ArrayList;
import com.tco.gamemanagement.Game;

public class Pawn extends Piece {
    public Pawn(Color color, int[] position) {
        super(PieceType.PAWN, color, position);
    }

    @Override
    public List<int[]> getPossibleMoves(Game game) {
        List<int[]> moves = new ArrayList<>();
        int direction = (getColor() == Color.WHITE) ? 1 : -1;

        // Move forward
        int[] forwardPos = {getPos()[0] + direction, getPos()[1]};
        if (game.isPositionOnBoard(forwardPos) && game.getPieceAt(forwardPos) == null) {
            moves.add(forwardPos);
        }
        // Pawns can move 2 spaces if it hasn't moved before
        int[] doubleMove = {this.getPos()[0] + (2 * direction), this.getPos()[1]};
        if (!this.hasMoved() && game.getPieceAt(doubleMove) == null) {
            moves.add(doubleMove);
        }

        // Capture diagonally
        int[] leftCapture = {getPos()[0] + direction, getPos()[1] - 1};
        int[] rightCapture = {getPos()[0] + direction, getPos()[1] + 1};

        if (game.isPositionOnBoard(leftCapture) && game.getPieceAt(leftCapture) != null && game.getPieceAt(leftCapture).getColor() != getColor()) {
            moves.add(leftCapture);
        }

        if (game.isPositionOnBoard(rightCapture) && game.getPieceAt(rightCapture) != null && game.getPieceAt(rightCapture).getColor() != getColor()) {
            moves.add(rightCapture);
        }

        return moves;
    }
}
