package com.example.tictactoe1.models;

import com.example.tictactoe1.exceptions.DuplicateSymbolException;
import com.example.tictactoe1.gamewinningstrategies.GameWinningStrategy;

import java.util.*;

public class Game {


    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private List<GameWinningStrategy> gameWinningStrategies;
    private int lastMovedPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;
    private int filledCells;

    private Game(){}

    public static Builder getBuilder(){
        return new Builder();
    }

    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public List<GameWinningStrategy> getGameWinningStrategies() {
        return gameWinningStrategies;
    }
    public void setGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
        this.gameWinningStrategies = gameWinningStrategies;
    }
    public int getLastMovedPlayerIndex() {
        return lastMovedPlayerIndex;
    }
    public void setLastMovedPlayerIndex(int lastMovedPlayerIndex) {
        this.lastMovedPlayerIndex = lastMovedPlayerIndex;
    }
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    public Player getWinner() {
        return winner;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void makeMove(){
        this.board.display();
        this.lastMovedPlayerIndex +=1;
        this.lastMovedPlayerIndex %=players.size();
        Move potentialMove = this.players.get(this.lastMovedPlayerIndex).makeMove(this.getBoard());
        if(this.board.getCell(potentialMove.getRow(), potentialMove.getCol()).getPlayer()!=null)
            System.out.println("Bad Move!!");
        else {
            this.moves.add(potentialMove);
            this.board.getCell(potentialMove.getRow(),
                            potentialMove.getCol()).setPlayer(this.players.get(this.lastMovedPlayerIndex));
            filledCells++;
        }
        for(GameWinningStrategy  gameWinningStrategy : gameWinningStrategies){
            if(gameWinningStrategy.checkVictory(board, potentialMove)) {
                this.setGameStatus(GameStatus.ENDED);
                this.winner = this.players.get(this.lastMovedPlayerIndex);
                return;
            }
        }
        int dimension = this.players.size()+1;
        if(filledCells == (dimension*dimension))
            this.setGameStatus(GameStatus.ENDED);
    }


    public static class Builder{

        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;

        public  Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public  Builder setGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
            this.gameWinningStrategies = gameWinningStrategies;
            return this;
        }

        public Game Build() throws DuplicateSymbolException {
            Set<Character> alreadyExistingPlayers = new HashSet<>();
            for(Player player : players) {
                if(alreadyExistingPlayers.contains(player.getSymbol().getSymbol()))
                    throw new DuplicateSymbolException(player.getSymbol().getSymbol());
                alreadyExistingPlayers.add(player.getSymbol().getSymbol());
            }
            Game game = new Game();
            game.gameStatus = GameStatus.IN_PROGRESS;
            game.gameWinningStrategies = gameWinningStrategies;
            game.players = players;
            game.moves = new ArrayList<>();
            game.board = new Board(players.size()+1);
            game.lastMovedPlayerIndex = -1;
            return game;
        }

    }

}
