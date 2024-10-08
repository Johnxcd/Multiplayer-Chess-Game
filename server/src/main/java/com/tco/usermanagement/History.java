package com.tco.usermanagement;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import com.tco.gameplaying.Match;

public class History {
    private int totalGames;
    private Map<String, Integer> matchRecord;
    private List<Match> matches;

    public History() {
        this.totalGames = 0;
        this.matchRecord = new HashMap<String, Integer>() {{
        put("Wins", 0);
        put("Losses", 0);
        put("Draws", 0);
        put("Ongoing", 0);
        }};
        this.matches = new ArrayList<Match>();
    }

    public int[] getRecord() {
        int[] record = new int[]{0, 0, 0, 0};
        record[0] = this.matchRecord.get("Wins");
        record[1] = this.matchRecord.get("Losses");
        record[2] = this.matchRecord.get("Draws");
        record[3] = this.matchRecord.get("Ongoing");
        return record;
    }

    public void updateHistory(Match match, String action) {
        if (action.equals("add")) {
            this.matches.add(match);
        } else if (action.equals("remove")) {
            this.matches.remove(match);
        } else {
            // invalid action input. Do nothing
            return;
        }
        this.updateRecord();
    }

    public void updateHistory(Match match) {
        this.updateHistory(match, "add");
    }

    private void updateRecord() {
        int[] temp = new int[]{0, 0, 0, 0};
        for (Match game : this.matches) {
            // String status = game.checkGameStatus();
            String status = "";
            if (status.equals("Win")) {
                temp[0] += 1;
            } else if (status.equals("Loss")) {
                temp[1] += 1;
            } else if (status.equals("Draws")) {
                temp[2] += 1;
            } else if (status.equals("Ongoing")) {
                temp[3] += 1;
            } else {
                // Throw error? Invalid game within matches list?
            };
        };
        this.matchRecord.put("Wins", temp[0]);
        this.matchRecord.put("Losses", temp[1]);
        this.matchRecord.put("Draws", temp[2]);
        this.matchRecord.put("Ongoing", temp[3]);
    }
}