package com.example.tictactoe1.botplayingstrategies;

import com.example.tictactoe1.models.Board;
import com.example.tictactoe1.models.Move;
import com.example.tictactoe1.models.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
