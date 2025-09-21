package org.games.superFour.utils;

import org.games.superfour.CellMove;
import org.games.superfour.utils.WinnerChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.games.superfour.utils.SuperFourUtils.getBoard;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinnerCheckerTest {

    @Test
    @DisplayName("Place 4 pieces for player 1 in a row")
    void testHorizontalWin() {
        int[][] board = getBoard();
        for (int c = 0; c < 4; c++) {
            board[0][c] = 1;
        }
        CellMove lastMove = new CellMove(0, 3);

        assertTrue(WinnerChecker.hasWinner(board, lastMove));
    }

    @Test
    @DisplayName("Place 4 pieces for player 2 in a column")
    void testVerticalWin() {
        int[][] board = getBoard();

        for (int r = 0; r < 4; r++) {
            board[r][0] = 2;
        }
        CellMove lastMove = new CellMove(3, 0);

        assertTrue(WinnerChecker.hasWinner(board, lastMove));
    }

    @Test
    @DisplayName("Place diagonal  for player 1")
    void testDiagonalDownRightWin() {
        int[][] board = getBoard();
        board[0][0] = 1;
        board[1][1] = 1;
        board[2][2] = 1;
        board[3][3] = 1;
        CellMove lastMove = new CellMove(3, 3);

        assertTrue(WinnerChecker.hasWinner(board, lastMove));
    }

    @Test
    @DisplayName("Place diagonal  for player 2")
    void testDiagonalDownLeftWin() {
        int[][] board = getBoard();
        board[0][3] = 2;
        board[1][2] = 2;
        board[2][1] = 2;
        board[3][0] = 2;
        CellMove lastMove = new CellMove(3, 0);

        assertTrue(WinnerChecker.hasWinner(board, lastMove));
    }

    @Test
    @DisplayName("test No Winner")
    void testNoWinner() {
        int[][] board = getBoard();
        board[0][0] = 1;
        board[0][1] = 2;
        board[0][2] = 1;
        board[0][3] = 2;
        CellMove lastMove = new CellMove(0, 3);

        assertFalse(WinnerChecker.hasWinner(board, lastMove));
    }
}