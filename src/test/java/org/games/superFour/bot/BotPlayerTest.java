package org.games.superFour.bot;

import org.games.superfour.bot.BotPlayer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BotPlayerTest {

    @Test
    @DisplayName("Bot should always select a column between 0 and 6")
    void testSelectBotColumnRange() {
        int[][] board = new int[6][7];

        for (int i = 0; i < 10; i++) { // run multiple times since it's random
            int col = BotPlayer.play(board);
            assertTrue(col >= 0 && col < 7);
        }
    }
}
