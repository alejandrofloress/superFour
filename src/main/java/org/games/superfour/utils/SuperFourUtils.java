package org.games.superfour.utils;

import org.games.superfour.constant.BoardSizeConstant;
import org.games.superfour.enums.PlayerEnum;

import java.util.OptionalInt;

public class SuperFourUtils {
   private static final int COLS = BoardSizeConstant.COLS;
   private static final int ROWS = BoardSizeConstant.ROWS;

   public static int [][] getBoard(){
        return new int[COLS][ROWS];
    }

    public static OptionalInt getAndValidateColumnInput(String inputValue) {
        try{
            int colInput = Integer.parseInt(inputValue.trim());
            if (colInput > 0 && colInput <= COLS){
                return OptionalInt.of(colInput - 1);
            } else {
                return OptionalInt.empty();
            }
        } catch (Exception e){
            return OptionalInt.empty();
        }
    }

    public static void printBoard(int[][] board) {
        for (int row = ROWS -1 ; row >= 0; row--) {
            for (int col = 0; col < COLS; col++) {
                PlayerEnum playerEnum = PlayerEnum.fromId(board[row][col]);
                System.out.print(printCellValue(playerEnum));
            }
            System.out.println();
        }
        //Print column numbers
        for (int col = 1; col <= COLS; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
    }

    public static String printCellValue(PlayerEnum playerEnum) {
        return playerEnum.symbol();
    }

    /**
     * Finds the first available row in the given column.
     *
     * @param board the game board
     * @param col   the column index
     * @return an OptionalInt with the row index if available, or empty if the column is full
     */
    public static OptionalInt dropPiece(int[][]  board, int col) {
        for (int row = 0; row <= 5; row++) {
            if (board[row][col] == 0) {
                return OptionalInt.of(row);
            }
        }
        //System.out.print("The column " +col + " is full!, choose another one.");
        return OptionalInt.empty();
    }
}
