package com.tco.gameplaying;

import java.util.List;
import com.tco.gamemanagement.User;
import com.tco.usermanagement.History;
import com.tco.gameplaying.Rules;
import com.tco.gamemanagement.Game;
import com.tco.gamemanagement.GameStatus;

public class Match extends Game {
    private List<User> users;
    private History history;
    private Rules rules;
    private Piece[][] board;

    public Match(List<User> users, History history, Rules rules) {
        this.users = users;
        this.history = history;
        this.rules = rules;
        createBoard();
    }

    public void createBoard() {
        // initialize the board with pieces in starting positions
        board = new Piece[8][8];

        // place pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.WHITE, new int[]{1, i});
            board[6][i] = new Pawn(Color.BLACK, new int[]{6, i});
        }
        
        board[0][0] = new Rook(Color.WHITE, new int[]{0, 0});
        board[0][7] = new Rook(Color.WHITE, new int[]{0, 7});
        board[7][0] = new Rook(Color.BLACK, new int[]{7, 0});
        board[7][7] = new Rook(Color.BLACK, new int[]{7, 7});
        board[0][1] = new Knight(Color.WHITE, new int[]{0, 1});
        board[0][6] = new Knight(Color.WHITE, new int[]{0, 6});
        board[7][1] = new Knight(Color.BLACK, new int[]{7, 1});
        board[7][6] = new Knight(Color.BLACK, new int[]{7, 6});
        // add other pieces
    }

    public boolean makeMove(Move move) {
        if (rules.validateMove(move, this)) {
            int[] start = move.getStart();
            int[] end = move.getEnd();
            board[end[0]][end[1]] = board[start[0]][start[1]];
            board[start[0]][start[1]] = null; // clear the start position

            // update piece position
            board[end[0]][end[1]].setPos(end);

            // check game status
            if (rules.checkGameStatus(this) != GameStatus.ONGOING) {
                endMatch();
            }
            return true;
        }
        return false;
    }

    public Piece getPieceAt(int[] position) {
        return board[position[0]][position[1]];
    }

    public boolean isPositionOnBoard(int[] position) {
        return position[0] >= 0 && position[0] < 8 && position[1] >= 0 && position[1] < 8;
    }

    public void endMatch() {
        //TODO: fill in
    }

    public void saveToHistory(List<User> users, History history) {
        //TODO: fill in
    }
}
