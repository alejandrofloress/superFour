package org.games.superfour.utils;

import java.util.OptionalInt;

public class SuperFourUtils {

    public static OptionalInt getAndValidateColumnInput(String col) {
        try{
            int colInput = Integer.parseInt(col.trim());
            if (colInput > 0 && colInput <= 7){
                return OptionalInt.of(colInput - 1);
            } else {
                return OptionalInt.empty();
            }
        } catch (Exception e){
            return OptionalInt.empty();
        }
    }

    public static void printBoard(int[][] board) {
        for (int row = 5; row >= 0; row--) {
            for (int col = 0; col < 7; col++) {
                Integer cellValue = board[row][col];
                if (cellValue.equals(0)) {
                    System.out.print("- ");
                } else
                    System.out.print(cellValue + " ");
            }
            System.out.println();
        }
        //Print column numbers
        for (int col = 1; col <= 7; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
    }
}
