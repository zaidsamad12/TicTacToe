package com.example.tictactoe1.models;

import java.util.Scanner;

public class Player {

    private Symbol symbol;
    private String name;
    private PlayerType type;
    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PlayerType getType() {
        return type;
    }
    public void setType(PlayerType type) {
        this.type = type;
    }

    public Move makeMove(Board board){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the row where you want to make the move.");
        int row = scanner.nextInt();

        System.out.println("Enter the column where you want to make the move.");
        int col = scanner.nextInt();

        Move move = new Move(row, col, this);
        return move;
    }

}
