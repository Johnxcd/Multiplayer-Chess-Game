package com.tco.gameplaying;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import com.tco.gamemanagement.Game;

public class Rook extends Piece {
    private static final Logger logger = Logger.getLogger(Rook.class.getName());

    public Rook(Color color, int[] position) {
        super(PieceType.ROOK, color, position);
    }

    @Override
    public List<int[]> getPossibleMoves(Game game) {
        List<int[]> moves = new ArrayList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  // Up, Down, Right, Left

        for (int[] direction : directions) {
            int[] pos = getPos().clone();
            while (true) {
                pos[0] += direction[0];
                pos[1] += direction[1];

                if (!game.isPositionOnBoard(pos)) break;  // Stop if out of bounds
                Piece pieceAtPos = game.getPieceAt(pos);  // Get the piece at the new position
                logger.info("Checking position: [" + pos[0] + ", " + pos[1] + "]");
                logger.info("Piece at position: " + pieceAtPos);
                if (pieceAtPos != null) {
                    if (pieceAtPos.getColor() != this.getColor()) {
                        moves.add(pos.clone());  // Capture move
                    }
                    break;  // Stop further movement in this direction after capturing
                } else {
                    moves.add(pos.clone());  // Normal move
                }
            }
        }
        logger.info("Total possible moves: " + moves.size());
        return moves;
    }
}
