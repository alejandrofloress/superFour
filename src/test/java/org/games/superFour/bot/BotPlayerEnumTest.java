package org.games.superFour.bot;

import org.games.superfour.CellMove;
import org.games.superfour.bot.BotPlayer;
import org.games.superfour.enums.PlayerEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.games.superfour.constant.BoardSizeConstant.COLS;
import static org.games.superfour.constant.BoardSizeConstant.ROWS;
import static org.junit.jupiter.api.Assertions.*;

public class BotPlayerEnumTest {

    @Test
    @DisplayName("Bot should play the winning move")
    void testBotPlaysWinningMove() {
        int[][] board = new int[ROWS][COLS];

        // Set up a horizontal winning opportunity for BOT
        board[0][0] = PlayerEnum.BOT.id;
        board[0][1] = PlayerEnum.BOT.id;
        board[0][2] = PlayerEnum.BOT.id;
        // column 3 is empty → should be winning move
        CellMove move = BotPlayer.play(board);

        assertEquals(0, move.getRow());
        assertEquals(3, move.getCol());
    }

    @Test
    @DisplayName("Bot should a random move")
    void testBotPlaysRandomMoveWhenNoWinner() {
        int[][] board = new int[ROWS][COLS];

        CellMove move = BotPlayer.play(board);

        assertNotNull(move);
        assertTrue(move.getCol() >= 0 && move.getCol() < COLS);
        assertTrue(move.getRow() >= 0 && move.getRow() < ROWS);
    }
}
