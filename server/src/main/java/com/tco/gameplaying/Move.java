package com.tco.gameplaying;

public class Move {
    private int[] start;
    private int[] end;

    public Move(int[] start, int[] end) {
        this.start = start;
        this.end = end;
    }

    public int[] getStart() {
        return start;
    }

    public int[] getEnd() {
        return end;
    }
}
