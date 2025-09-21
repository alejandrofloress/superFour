package org.games.superfour.utils;

public class Main {
    public static void main(String[] args) {
        int[][] board = new int[6][7];

        board[0][0] = 1;
        board[2][2] = 3;
        board[5][5] = 6;
        board[5][6] = 7;


        SuperFourUtils.printBoard(board);

    }


}