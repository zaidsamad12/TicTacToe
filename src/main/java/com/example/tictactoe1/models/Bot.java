package com.example.tictactoe1.models;

public class Bot extends Player {

    private BotDifficultyLevel botDifficultyLevel;

    public Bot(BotDifficultyLevel botDifficultyLevel) {
        super();
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
