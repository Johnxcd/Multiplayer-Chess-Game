package com.tco.gameplaying;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import com.tco.gamemanagement.Game;

public class Knight extends Piece {
    private static final Logger logger = Logger.getLogger(Knight.class.getName());

    public Knight(Color color, int[] position) {
        super(PieceType.KNIGHT, color, position);
    }

    @Override
    public List<int[]> getPossibleMoves(Game game) {
        List<int[]> moves = new ArrayList<>();
        int[][] directions = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };  // possible L-shaped moves

        for (int[] direction : directions) {
            int[] pos = {getPos()[0] + direction[0], getPos()[1] + direction[1]};
            if (game.isPositionOnBoard(pos)) {
                Piece pieceAtPos = game.getPieceAt(pos);
                logger.info("Checking position: [" + pos[0] + ", " + pos[1] + "]");
                logger.info("Piece at position: " + pieceAtPos);
                if (pieceAtPos == null || pieceAtPos.getColor() != this.getColor()) {
                    moves.add(pos);  // add move if empty or occupied by opponents piece
                }
            }
        }
        logger.info("Total possible moves: " + moves.size());
        return moves;
    }
}