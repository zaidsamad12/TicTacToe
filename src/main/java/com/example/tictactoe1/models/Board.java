package com.example.tictactoe1.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int dimension;
    private List<List<Cell>> board;
    public int getDimension() {
        return dimension;
    }
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    public List<List<Cell>> getBoard() {
        return board;
    }

    public Board(int dimension) {
        super();
        this.dimension = dimension;
        this.board = new ArrayList<>();

        for(int i=0 ;i<dimension; i++) {
            this.board.add(new ArrayList<Cell>());

            for(int j=0; j<dimension; j++)
                this.board.get(i).add(new Cell(j, j));
        }


    }
    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }


}
