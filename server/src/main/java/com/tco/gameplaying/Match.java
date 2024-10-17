package com.tco.gameplaying;

import java.util.List;
import com.tco.gamemanagement.User;
import com.tco.usermanagement.History;
import com.tco.gameplaying.Rules;
import com.tco.gamemanagement.Game;
import com.tco.gamemanagement.GameStatus;

public class Match extends Game {
    private Rules rules;        // rule set we abide by
    private GameStatus status;  // game status {ONGOING, DRAW, CHECKMATE}
    private List<Move> moves;   // list of all moves made to date

    public Match(User[] users, Rules rules) {
        super(users);
        this.rules = rules;
        this.moves = new ArrayList<Move>();
        this.status = GameStatus.ONGOING;
    }

    public GameStatus getStatus() { return this.status; }
    public void setStatus(GameStatus status) { this.status = status; }

    public boolean makeMove(Move move) {
        if (rules.validateMove(move, this)) {
            int[] start = move.getStart();
            int[] end = move.getEnd();
            board[end[0]][end[1]] = board[start[0]][start[1]];
            board[start[0]][start[1]] = null; // clear the start position

            // update piece position
            board[end[0]][end[1]].setPos(end);
            this.addMove(move);

            // check game status
            if (rules.checkGameStatus(this, board) != GameStatus.ONGOING) {
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
