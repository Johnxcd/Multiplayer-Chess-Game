package com.tco.usermanagement;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import com.tco.gameplaying.Match;
import com.tco.gamemanagement.GameStatus;

public class History {
    private static final Logger log = Logger.getLogger(History.class.getName());
    private int totalGames;
    private Map<GameStatus, Integer> record;
    private List<Match> matches;

    public History() {
        this.totalGames = 0;
        this.record = new HashMap<GameStatus, Integer>() {{
        put(GameStatus.CHECKMATE, 0); // The user's total checkmates, not overall
        put(GameStatus.DRAW, 0);
        put(GameStatus.ONGOING, 0);
        put(GameStatus.LOSS, 0); // Added LOSS to the record map
        }};
        this.matches = new ArrayList<Match>();
    }

    // returns array [W, L, D, O, Total]
    public int[] getRecord() {
        // ensure the record is 100% accurate every call
        this.forceUpdate();

        int[] record = new int[]{0, 0, 0, 0, 0};
        record[0] = this.record.get(GameStatus.CHECKMATE); // W
        record[1] = this.record.get(GameStatus.LOSS);      // L
        record[2] = this.record.get(GameStatus.DRAW);      // D
        record[3] = this.record.get(GameStatus.ONGOING);   // O
        record[4] = this.totalGames;                       // Total
        log.info("Current record: " + Arrays.toString(record));
        return record;
    }

    public void add(Match match) {
        this.updateRecord(match, 1);
        this.matches.add(match);
        log.info("Added match with status: " + match.getStatus());
    }

    public void remove(Match match) {
        this.updateRecord(match, -1);
        this.matches.remove(match);
        log.info("Removed match with status: " + match.getStatus());
    }

    // helper function to add, remove and forceUpdate
    private void updateRecord(Match match, int value) {
        GameStatus status = match.getStatus();
        this.record.merge(status, value, Integer::sum);
        this.totalGames += value;
        log.info("Updated record for status " + status + " by " + value);
    }

    // A match can update it's status without history knowing.
    // The record must reflect the accurate representation of w/l/d/o
    void forceUpdate() {
        this.record.put(GameStatus.CHECKMATE, 0);
        this.record.put(GameStatus.LOSS, 0);
        this.record.put(GameStatus.DRAW, 0);
        this.record.put(GameStatus.ONGOING, 0);

        this.countRecord();
    }

    private void countRecord() {
        for (Match match : this.matches) {
            GameStatus status = match.getStatus();
            this.record.merge(status, 1, Integer::sum);

        }
    }
}