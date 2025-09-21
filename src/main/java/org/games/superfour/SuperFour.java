package org.games.superfour;

import org.games.superfour.utils.SuperFourUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.OptionalInt;

public class SuperFour {
    public void runGame() throws Exception {

        int[][] board = new int[6][7];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter column index (1-7): ");

        OptionalInt col = SuperFourUtils.getAndValidateColumnInput(reader.readLine());
        // Ask user for column
        if (col.isEmpty()) {
            System.out.println("Invalid input! Enter a column number between 1 and 7.");
        } else {
            board[0][col.getAsInt()] = 1;
        }
        SuperFourUtils.printBoard(board);
    }
}
