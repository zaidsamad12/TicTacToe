package com.example.tictactoe1.factories;

import com.example.tictactoe1.botplayingstrategies.BotPlayingStrategy;
import com.example.tictactoe1.botplayingstrategies.RandomBotPlayingStrategy;
import com.example.tictactoe1.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyFactory(BotDifficultyLevel botDifficultyLevel){
        return new RandomBotPlayingStrategy();
    }
}
