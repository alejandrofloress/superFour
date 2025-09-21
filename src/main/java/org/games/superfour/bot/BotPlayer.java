package org.games.superfour.bot;

import java.util.concurrent.ThreadLocalRandom;

public class BotPlayer {
    public static int play(int[][] gameBoard) {
        // TODO implement smarter logic
        return ThreadLocalRandom.current().nextInt(7);
    }
}
