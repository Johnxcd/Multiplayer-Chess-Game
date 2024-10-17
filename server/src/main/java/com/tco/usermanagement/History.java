package com.tco.usermanagement;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.tco.gameplaying.Match;
import com.tco.gamemanagement.GameStatus;

public class History {
    private int totalGames;
    private Map<GameStatus, Integer> record;
    private List<Match> matches;

    public History() {
        this.totalGames = 0;
        this.record = new HashMap<GameStatus, Integer>() {{
        put(GameStatus.CHECKMATE, 0); // The user's total checkmates, not overall
        put(GameStatus.DRAW, 0);
        put(GameStatus.ONGOING, 0);
        }};
        this.matches = new ArrayList<Match>();
    }

    // returns array [W, L, D, O, Total]
    public int[] getRecord() {
        // ensure the record is 100% accurate every call
        this.forceUpdate();
        
        int[] record = new int[]{0, 0, 0, 0, 0};
        record[0] = this.record.get(GameStatus.CHECKMATE); // W
        record[2] = this.record.get(GameStatus.DRAW);      // D
        record[3] = this.record.get(GameStatus.ONGOING);   // O
        record[4] = this.totalGames;                       // Total
        // Doesn't actually keep track of losses, only reports wins
        // fix later?                                      // L
        record[1] = this.totalGames - record[0] - record[2] - record[3];
        return record;
    }

    public void add(Match match) {
        this.updateRecord(match, 1);
        this.matches.add(match);
    }

    public void remove(Match match) {
        this.updateRecord(match, -1);
        this.matches.remove(match);
    }

    // helper function to add, remove and forceUpdate
    private void updateRecord(Match match, int value) {
        //GameStatus status = match.checkGameStatus();
        // if status == GameStatus.CHECKMATE {
        //     // do nothing and return if game is not a win for this user
        // }
        //this.record.merge(status, value, Integer::sum);
        this.record.merge(GameStatus.ONGOING, value, Integer::sum);
        this.totalGames += value;
    }

    // A match can update it's status without history knowing.
    // The record must reflect the accurate representation of w/l/d/o
    private void forceUpdate() {
        int[] record = countRecord();
        this.record.put(GameStatus.ONGOING, record[0]);
        this.record.put(GameStatus.DRAW, record[1]);
        this.record.put(GameStatus.ONGOING, record[2]);
    }

    private int[] countRecord() {
        int[] record = new int[]{0, 0, 0};
        for (Match match : this.matches) {
            updateRecord(match, 1);
        }
        return record;
    }
}