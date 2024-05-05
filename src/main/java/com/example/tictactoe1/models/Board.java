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
                this.board.get(i).add(new Cell(i, j));
        }
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
    public Cell getCell(int row, int col){
        return this.board.get(row).get(col);
    }

    public void display() {
        for(int i =0; i< this.dimension; i++){
            for(int j =0; j< this.dimension; j++){
                if((this.board.get(i).get(j)).getPlayer() == null)
                    System.out.print(" - ");
                else
                    System.out.print(" " + this.board.get(i).get(j).getPlayer().getSymbol().getSymbol() + " ");
            }
            System.out.println();
        }
    }
}
