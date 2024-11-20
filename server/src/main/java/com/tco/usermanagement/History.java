package com.tco.usermanagement;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.tco.gameplaying.Match;
import com.tco.gamemanagement.GameStatus;

public class History {
    private int totalGames;
    private Map<String, Integer> record;
    private List<Match> matches;
    private String username;

    public History() {
        this.totalGames = 0;
        this.record = new HashMap<String, Integer>() {{
        put("WIN", 0); // The user's total checkmates, not overall
        put("LOSS", 0);
        put("DRAW", 0);
        put("ONGOING", 0);
        }};
        this.matches = new ArrayList<Match>();
        this.username = "";
    }

    // returns array [W, L, D, O, Total]
    public int[] getRecord() {
        // ensure the record is 100% accurate every call
        this.forceUpdate();

        int[] record = new int[]{0, 0, 0, 0, 0};
        record[0] = this.record.get("WIN");       // W
        record[1] = this.record.get("LOSS");      // L
        record[2] = this.record.get("DRAW");      // D
        record[3] = this.record.get("ONGOING");   // O
        record[4] = this.totalGames;              // Total
        return record;
    }

    public void add(Match match, String username) {
        this.updateRecord(match, 1, username);
        this.matches.add(match);
        this.username = username;
    }

    public void remove(Match match, String username) {
        this.updateRecord(match, -1, username);
        this.matches.remove(match);
    }

    public String translateStatus(Match match, String username) {
        GameStatus status = match.getStatus();
        // TODO: check if the checkmate is the user's, return win or loss depending on the result 
        if (status == GameStatus.WHITECHECKMATE || status == GameStatus.BLACKCHECKMATE) { return "WIN"; /* else { return "LOSS"} */} 
        else if (status == GameStatus.DRAW) { return "DRAW"; } 
        // ONGOING, WHITECHECK, BLACKCHECK
        else { return "ONGOING"; }
    }

    // helper function to add, remove and forceUpdate
    private void updateRecord(Match match, int value, String username) {
        String status = translateStatus(match, username);

        this.record.merge(status, value, Integer::sum);
        this.totalGames += value;
    }

    // A match can update it's status without history knowing.
    // The record must reflect the accurate representation of w/l/d/o
    private void forceUpdate() {
        this.record.put("WIN", 0);
        this.record.put("LOSS", 0);
        this.record.put("DRAW", 0);
        this.record.put("ONGOING", 0);
        this.totalGames = 0;

        this.countRecord();
    }

    private void countRecord() {
        for (Match match : this.matches) {
            updateRecord(match, 1, this.username);
        }
    }
}