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

            Piece startPiece = board[start[0]][start[1]];
            Piece endPiece = board[end[0]][end[1]];
            if (endPiece == null) {
                this.capturePiece(start, end, null);
            } // TODO: define castling conditions
            
            this.addMove(startPiece, move);

            // check game status
            this.status = rules.checkGameStatus(this, board);
            if (this.status != GameStatus.ONGOING) {
                endMatch();
            }
            return true;
        }
        return false;
    }

    public void capturePiece(int[] start, int[] end, int[] enPassantCapture) {
        board[end[0]][end[1]] = board[start[0]][start[1]];
        board[end[0]][end[1]].setPos(end);

        // If en passant, then this additional location must be cleared
        if (enPassantCapture != null) {
            board[enPassantCapture[0]][enPassantCapture[1]] = null;
        } 
        board[start[0]][start[1]] = null;
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

}
