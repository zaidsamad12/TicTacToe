package com.example.tictactoe1.factories;

import com.example.tictactoe1.models.*;

public class PlayerFactory {

    public static Player getPlayerFactory(PlayerType playerType, String name, Character symbol,
                                BotDifficultyLevel botDifficultyLevel){
         switch (playerType){
            case HUMAN:
                return createHumanPlayer(name, symbol);
             case BOT:
                 return createBotPlayer(name, symbol, botDifficultyLevel);
             default:
                 throw new IllegalArgumentException("Unknown player type: " + playerType);
         }
    }

    private static Player createHumanPlayer(String name, char symbol){
        Player player = new Player();
        player.setName(name);
        player.setType(PlayerType.HUMAN);
        player.setSymbol(new Symbol(symbol));
        return player;
    }
    private static Player createBotPlayer(String name, char symbol, BotDifficultyLevel botDifficultyLevel){
        Bot bot = new Bot(botDifficultyLevel);
        bot.setType(PlayerType.BOT);
        bot.setSymbol(new Symbol(symbol));
        bot.setName(name);
        return bot;
    }
}
