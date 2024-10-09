package com.tco.gameplaying;

public class Piece {
    private String name;
    private String color;
    private int[] position;

    public Piece(String name, String color, int[] position) {
        this.name = name;
        this.color = color;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public int[] getPos() {
        return this.position;
    }

    public void setPos(int[] position) {
        this.position = position;
    }
}
