package com.example.tictactoe1.factories;

import com.example.tictactoe1.gamewinningstrategies.GameWinningStrategy;
import com.example.tictactoe1.models.GameWinningStrategyName;

public class GameWininngStrategyFactory {

    public static GameWinningStrategy getGameWinningStrategyByName(String name){
            if(name.equalsIgnoreCase(String.valueOf(GameWinningStrategyName.COLUMN)))
                return null;
            else if(name.equalsIgnoreCase(String.valueOf(GameWinningStrategyName.ROW)))
                return null;
            else if(name.equalsIgnoreCase(String.valueOf(GameWinningStrategyName.DIAGONAL)))
                return null;
            else
                return null;
    }
}
