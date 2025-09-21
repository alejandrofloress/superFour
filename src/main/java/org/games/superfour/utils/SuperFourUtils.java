package org.games.superfour.utils;

import org.games.superfour.constant.BoardSizeConstant;
import org.games.superfour.enums.PlayerEnum;

import java.util.OptionalInt;

public class SuperFourUtils {
   private static final int COLS = BoardSizeConstant.COLS;
   private static final int ROWS = BoardSizeConstant.ROWS;

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
}
