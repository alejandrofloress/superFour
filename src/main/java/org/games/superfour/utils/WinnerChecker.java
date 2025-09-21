package org.games.superfour.utils;

import org.games.superfour.CellMove;

import static org.games.superfour.constant.BoardSizeConstant.COLS;
import static org.games.superfour.constant.BoardSizeConstant.ROWS;

public class WinnerChecker {

    private WinnerChecker() {
        // Util class, prevent instantiation
    }

    private static final int WINNING_COUNT = 4;

    public static boolean hasWinner(int[][] board, CellMove cellMove) {
        int row = cellMove.getRow();
        int col = cellMove.getCol();
        int player = board[row][col];
        if (player == 0) return false;

        return checkHorizontal(board, row, col, player)
                || checkVertical(board, row, col, player)
                || checkDiagonalDownRight(board, row, col, player)
                || checkDiagonalDownLeft(board, row, col, player);
    }

    private static boolean checkHorizontal(int[][] board, int row, int col, int player) {
        int consecutiveCount = 1;
        consecutiveCount += countDirection(board, row, col, 0, 1, player);  // right
        consecutiveCount += countDirection(board, row, col, 0, -1, player); // left
        return consecutiveCount >= WINNING_COUNT;
    }

    private static boolean checkVertical(int[][] board, int row, int col, int player) {
        int consecutiveCount = 1;
        consecutiveCount += countDirection(board, row, col, 1, 0, player);  // down
        consecutiveCount += countDirection(board, row, col, -1, 0, player); // up
        return consecutiveCount >= WINNING_COUNT;
    }

    private static boolean checkDiagonalDownRight(int[][] board, int row, int col, int player) {
        int consecutiveCount = 1;
        consecutiveCount += countDirection(board, row, col, 1, 1, player);   // down-right
        consecutiveCount += countDirection(board, row, col, -1, -1, player); // up-left
        return consecutiveCount >= WINNING_COUNT;
    }

    private static boolean checkDiagonalDownLeft(int[][] board, int row, int col, int player) {
        int consecutiveCount = 1;
        consecutiveCount += countDirection(board, row, col, 1, -1, player);  // down-left
        consecutiveCount += countDirection(board, row, col, -1, 1, player);  // up-right
        return consecutiveCount >= WINNING_COUNT;
    }

    private static int countDirection(int[][] board, int row, int col,
                                      int rowStep, int colStep, int player) {
        int consecutivePieces = 0;
        int currentRow = row + rowStep;
        int currentCol = col + colStep;

        while (currentRow >= 0 && currentRow < ROWS &&
                currentCol >= 0 && currentCol < COLS) {

            if (board[currentRow][currentCol] == player) {
                consecutivePieces++;
                currentRow += rowStep;
                currentCol += colStep;
            } else {
                break;
            }
        }

        return consecutivePieces;
    }
}
