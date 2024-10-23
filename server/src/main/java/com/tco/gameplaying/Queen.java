package com.tco.gameplaying;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import com.tco.gamemanagement.Game;

public class Queen extends Piece {
    private static final Logger logger = Logger.getLogger(Queen.class.getName());

    public Queen(Color color, int[] position) {
        super(PieceType.QUEEN, color, position);
    }

    @Override
    public List<int[]> getPossibleMoves(Game game) {
        List<int[]> moves = new ArrayList<>();
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},  // up down left right
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}  // diagonal
        };

        for (int[] direction : directions) {
            int[] pos = getPos().clone();
            while (true) {
                pos[0] += direction[0];
                pos[1] += direction[1];

                if (!game.isPositionOnBoard(pos)) break;
                Piece pieceAtPos = game.getPieceAt(pos);
                logger.info("Checking position: [" + pos[0] + ", " + pos[1] + "]");
                logger.info("Piece at position: " + pieceAtPos);
                if (pieceAtPos != null) {
                    if (pieceAtPos.getColor() != this.getColor()) {
                        moves.add(pos.clone());  // capture move
                    }
                    break;  // stop movement after capturing
                } else {
                    moves.add(pos.clone());  // or normal move
                }
            }
        }
        logger.info("Total possible moves: " + moves.size());
        return moves;
    }
}
