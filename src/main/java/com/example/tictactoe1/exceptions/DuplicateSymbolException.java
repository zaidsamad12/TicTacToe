package com.example.tictactoe1.exceptions;

public class DuplicateSymbolException extends Throwable {
    public DuplicateSymbolException(Character character) {
        System.out.print("Symbol "+ character+"is already taken");
    }

}
