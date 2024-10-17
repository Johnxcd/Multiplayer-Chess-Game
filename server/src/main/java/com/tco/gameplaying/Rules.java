package com.tco.gameplaying;

import java.util.List;
import com.tco.gamemanagement.Game;
import com.tco.gamemanagement.User;
import com.tco.gamemanagement.GameStatus;
import com.tco.gameplaying.Piece;

public class Rules {

    public boolean validateMove(Move move, Game game) {
        Piece piece = game.getPieceAt(move.getStart());
        if (piece == null) return false; // No piece at the start position
        
        List<int[]> possibleMoves = piece.getPossibleMoves(game);
        for (int[] pos : possibleMoves) {
            if (pos[0] == move.getEnd()[0] && pos[1] == move.getEnd()[1]) {
                return true;
            }
        }
        return false;
    }

    // turn order
    public User determineTurnOrder(List<User> users) {
        return users.get(0); // assuming turn order is based on the list index
    }

    // game status (win, loss, draw)
    public GameStatus checkGameStatus(Game game, Piece[][] board) {
        // check the game status based on pieces left, checkmate, etc.
        // returning ONGOING for now
        return GameStatus.ONGOING;
    }
}
    
