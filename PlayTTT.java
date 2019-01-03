package com.company;

import java.util.Scanner;

public class PlayTTT {
    private int row, col;
    private Scanner sc = new Scanner(System.in);
    private char player = 'X';
    private String playAgain = "J";

    public PlayTTT() {

        this.row = row;
        this.col = col;
    }

    public void play() {

        Board board = new Board();


        while (playAgain.equalsIgnoreCase("J")) {

            System.out.println("Välkommer till Tre i rad. Vänligen börja spela\n");

            boolean play = true;
            while (play) { // startar spelet

                board.printBoard();
                System.out.println("\nSpelare " + player + " slå in en rad mellan 1-3: ");
                this.row = sc.nextInt() - 1; // -1 för att mata in rad 1 istället för 0
                System.out.println("Spelare " + player + " slå in en column mellan 1-3");
                this.col = sc.nextInt() - 1;

                if (board.markerTaken(row, col, player)) {
                    System.out.println("Platsen är upptagen, försök igen");
                    System.out.println("\nSpelare " + player + " slå in en rad mellan 1-3: ");
                    this.row = sc.nextInt() - 1;
                    System.out.println("Spelare " + player + " slå in en column mellan 1-3");
                    this.col = sc.nextInt() - 1;

                    board.placeMarker(row, col, player);

                }

                board.placeMarker(row,col, player);




                if (board.winner(row, col)) {
                    play = false;
                    System.out.println("\nVinnare är " + player + "!");
                    board.printBoard();
                }

                if (board.fullBoard() && !board.winner(row, col)) {
                    System.out.println("\nDet blev oavgjort");
                }
                if (board.fullBoard()) {
                    play = false;
                }



                if (player == 'X') {     // ändrar spelare
                    player = 'O';
                } else {
                    player = 'X';
                }
            }
            System.out.println("\nVill du spela igen? (J/N)?");
            playAgain = sc.next();
            board.resetBoard();
        }
    }



}
