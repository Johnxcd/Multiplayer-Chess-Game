package com.tco.requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tco.gameplaying.Move;
import com.tco.gameplaying.Match;
import com.tco.gameplaying.Piece;
import com.tco.misc.BadRequestException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveRequest extends Request {

    private static final transient Logger log = LoggerFactory.getLogger(MoveRequest.class);

    private String uuid;
    private int[] from;
    private int[] to;
    private List<int[]> possibleMoves;
    private static Map<String, Match> matchStorage = new HashMap<>(); // temporary in memory storage for matches

    @Override
    public void buildResponse() throws BadRequestException {
        Match match = matchStorage.get(uuid);
        if (match == null) {
            throw new BadRequestException("Game not found: " + uuid);
        }

        Move move = new Move(from, to);
        if (validateMove(move, match)) {
            match.makeMove(move);
            possibleMoves = match.getPieceAt(to).getPossibleMoves(match);
        } else {
            throw new BadRequestException("Invalid move");
        }

        log.trace("buildResponse -> {}", this);
    }

    private boolean validateMove(Move move, Match match) {
        Piece piece = match.getPieceAt(move.getStart());
        if (piece == null) return false; // no piece at the start position
        
        List<int[]> possibleMoves = piece.getPossibleMoves(match);
        for (int[] pos : possibleMoves) {
            if (pos[0] == move.getEnd()[0] && pos[1] == move.getEnd()[1]) {
                return true;
            }
        }
        return false;
    }

    public MoveRequest() {
        this.requestType = "move";
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int[] getFrom() {
        return from;
    }

    public void setFrom(int[] from) {
        this.from = from;
    }

    public int[] getTo() {
        return to;
    }

    public void setTo(int[] to) {
        this.to = to;
    }

    public List<int[]> getPossibleMoves() {
        return possibleMoves;
    }

    public static void setMatchStorage(Map<String, Match> storage) {
        matchStorage = storage;
    }

    public static Map<String, Match> getMatchStorage() {
        return matchStorage;
    }
}
