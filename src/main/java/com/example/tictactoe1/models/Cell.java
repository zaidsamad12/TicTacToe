package com.example.tictactoe1.models;

public class Cell {

    Player player;
    int row;
    int col;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell(int row, int col) {
        super();
        this.row = row;
        this.col = col;

    }
}
