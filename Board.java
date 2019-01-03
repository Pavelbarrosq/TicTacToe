package com.company;

public class Board {

    private char[][] board; //Skapa 2D Array

    public Board() {
        this.board = new char[3][3]; //
        resetBoard();
    }

    public void printBoard() { // loopa igenom och sätta in skelettet på brädan


        for(int i = 0; i < 3; i++){
            System.out.print(" | "); // sätter de 3 första raderna med |
            for(int j = 0; j < 3; j++){
                System.out.print(board [i][j] + " | "); // sätter de 3 sista på varje rad med |
            }
            System.out.println();

        }

        System.out.println();


    }

    public void resetBoard() { // sätter om brädan på nytt genom att sätta '-'
        for(int i = 0; i < 3; i++){
            for(int j = 0; j <3; j++){
                board[i][j] = '-';
            }
        }
    }

    public boolean fullBoard() { // kollar om brädan är full. Känner den av '-' så är brädan inte full
        boolean fullBoard = true;

        for (int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    fullBoard = false;
                }
            }
        }
        return fullBoard;
    }

    protected boolean winner(int row, int col) {
        if (board[0][col] == board[1][col] && board[0][col] == board[2][col] // vinst i columner
                && board[1][col] != '-')
            return true;
        if (board[row][0] == board[row][1] && board[row][0] == board[row][2] // kollar för vinst i rader
                && board[1][row] != '-')
            return true;
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]
                && board[1][1] != '-')
            return true;
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0]
                && board [1][1] != '-')
            return true;

        return false;
    }

    protected boolean markerTaken(int row, int col, char player) {

        if (board[row][col] == 'X' || board[row][col] == 'O') {
            return true;
        } else {
            board[row][col] = player;
        }

        return false;
    }

    public void placeMarker(int row, int col, char player) {
        board[row][col] = player;
    }



}