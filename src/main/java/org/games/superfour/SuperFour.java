package org.games.superfour;

import org.games.superfour.bot.BotPlayer;
import org.games.superfour.enums.PlayerEnum;
import org.games.superfour.utils.SuperFourUtils;

import java.io.BufferedReader;
import java.util.OptionalInt;


public class SuperFour {
    public void runGame(BufferedReader reader) throws Exception {
        boolean gameIsActive = true;
        do {
            int[][] board = SuperFourUtils.getBoard();
            SuperFourUtils.printBoard(board);

            System.out.print("Enter column index (1-7): ");

            OptionalInt col = SuperFourUtils.getAndValidateColumnInput(reader.readLine());
            // Ask user for column
            if (col.isEmpty()) {
                System.out.println("Invalid input! Enter a column number between 1 and 7.");
            } else {
                OptionalInt row = SuperFourUtils.dropPiece(board, col.getAsInt());
                if (row.isPresent()) {
                    board[row.getAsInt()][col.getAsInt()] = PlayerEnum.HUMAN.id;
                }
            }
            // Add Bot input
            int botColumn = BotPlayer.play(board);
            board[0][botColumn] = PlayerEnum.BOT.id;

            SuperFourUtils.printBoard(board);
        } while (gameIsActive);
    }

}
