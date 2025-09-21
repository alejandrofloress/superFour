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
                int cellValue = board[row][col];
                System.out.print(printCellValue(cellValue));
            }
            System.out.println();
        }
        //Print column numbers
        for (int col = 1; col <= 7; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
    }

    public static String printCellValue(int cellValue) {
        if (cellValue == 1) {
            return "X ";
        } else
        if (cellValue == 2) {
            return "0 ";
        } else {
            return "- ";
        }
    }
}
