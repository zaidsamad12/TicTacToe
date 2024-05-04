package com.example.tictactoe1.factories;

import com.example.tictactoe1.models.BotDifficultyLevel;

 public class BotDifficultyLevelFactory {

    public static BotDifficultyLevel getBotDifficultyLevel(String botDifficultyLevel){
         if(botDifficultyLevel.equalsIgnoreCase(String.valueOf(BotDifficultyLevel.EASY)))
             return BotDifficultyLevel.EASY;
         else if(botDifficultyLevel.equalsIgnoreCase(String.valueOf(BotDifficultyLevel.MEDIUM)))
             return BotDifficultyLevel.MEDIUM;
         else return BotDifficultyLevel.HARD;
    }
}
