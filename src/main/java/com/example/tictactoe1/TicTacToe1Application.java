package com.example.tictactoe1;

import com.example.tictactoe1.exceptions.DuplicateSymbolException;
import com.example.tictactoe1.factories.BotDifficultyLevelFactory;
import com.example.tictactoe1.factories.GameWininngStrategyFactory;
import com.example.tictactoe1.factories.PlayerFactory;
import com.example.tictactoe1.gamewinningstrategies.GameWinningStrategy;
import com.example.tictactoe1.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToe1Application {

    public static void main(String[] args) throws DuplicateSymbolException {
        SpringApplication.run(TicTacToe1Application.class, args);
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many players?");
        int numberOfPlayers = scanner.nextInt();

        List<Player> players = new ArrayList<>();

        for(int i=0; i<numberOfPlayers ;i++){
            System.out.println("Name of Player? "+i+1);
            String playerName = scanner.next();

            System.out.println("Symbol of Player? "+i+1);
            Character symbol = scanner.next().charAt(0);

            Player  humanPlayer =  PlayerFactory.getPlayerFactory(PlayerType.HUMAN, playerName, symbol, null);
            players.add(humanPlayer);
        }

        System.out.println("How many bots?");
        int numberOfBots = scanner.nextInt();

        for(int i=0; i<numberOfBots ;i++){
            System.out.println("Name of Bot? "+i+1);
            String botName = scanner.next();

            System.out.println("Symbol of Bot? "+i+1);
            Character symbol = scanner.next().charAt(0);

            System.out.println("Difficulty level of Bot? "+i+1);
            String difficultyLevel = scanner.next();
            BotDifficultyLevel botDifficultyLevel = BotDifficultyLevelFactory.getBotDifficultyLevel("easy");
            Player  bot =  PlayerFactory.getPlayerFactory(PlayerType.BOT, botName, symbol, botDifficultyLevel);
            players.add(bot);
        }

        System.out.println("Enter number of  game winning strategy");
        int numberOfGameWinningStrategies = scanner.nextInt();
        List<GameWinningStrategy> gameWinningStrategies = new ArrayList<>();
        for(int i=0; i<numberOfGameWinningStrategies; i++){
            System.out.println("Enter name of  game winning strategy "+(i+1));
            String gameWinningStrategyName = scanner.next();
            GameWinningStrategy gameWinningStrategy = GameWininngStrategyFactory.getGameWinningStrategyByName(gameWinningStrategyName);
            gameWinningStrategies.add(gameWinningStrategy);
        }

        Game game = Game.getBuilder()
                .setPlayers(players).
                setGameWinningStrategies(gameWinningStrategies).Build();

        while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            game.makeMove();
        }

    }

}
