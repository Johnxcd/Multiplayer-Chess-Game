package com.tco.gameplaying;

import java.util.List;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.UUID;
import com.tco.gamemanagement.User;
import com.tco.gamemanagement.GameStatus;
import com.tco.gamemanagement.Game;

public class Match extends Game {
    private Rules rules;        // rule set we abide by
    private GameStatus status;  // game status {ONGOING, DRAW, CHECKMATE}
    private List<Entry<Piece, Move>> moves;   // list of all moves made to date
    private String matchID;

    public Match(User[] users, Rules rules) {
        super(users);
        this.matchID = UUID.randomUUID().toString();
        this.rules = rules;
        this.moves = new ArrayList<>();
        this.status = GameStatus.ONGOING;
    }

    public String getMatchID() { return matchID; }
    public GameStatus getStatus() { return this.status; }
    public void setStatus(GameStatus status) { this.status = status; }
    public void addMove(Piece piece, Move move) {
        SimpleEntry<Piece, Move> entry = new SimpleEntry<>(piece, move);
        moves.add(entry);
    }

    public boolean makeMove(Move move) {
        if (rules.validateMove(move, this)) {
            int[] start = move.getStart();
            int[] end = move.getEnd();
            board[end[0]][end[1]] = board[start[0]][start[1]];
            board[start[0]][start[1]] = null; // clear the start position

            // update piece position
            board[end[0]][end[1]].setPos(end);
            this.addMove(getPieceAt(start), move);

            // check game status
            if (rules.checkGameStatus(this, board) != GameStatus.ONGOING) {
                endMatch();
            }
            return true;
        }
        return false;
    }

    public Piece getPieceAt(int[] position) {
        Piece piece = board[position[0]][position[1]];
        return piece;
    }


    public boolean isPositionOnBoard(int[] pos) {
        return pos[0] >= 0 && pos[0] < 8 && pos[1] >= 0 && pos[1] < 8;
    }

    public void endMatch() {
        //TODO: fill in
    }

}
