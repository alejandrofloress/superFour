package org.games.superfour;

import org.games.superfour.bot.BotPlayer;
import org.games.superfour.enums.PlayerEnum;
import org.games.superfour.utils.SuperFourUtils;

import java.io.BufferedReader;
import java.util.OptionalInt;


public class SuperFour {
    public void runGame(BufferedReader reader) throws Exception {
        boolean gameIsActive = true;
        int[][] board = SuperFourUtils.getBoard();
        while (gameIsActive) {
            SuperFourUtils.printBoard(board);
            // User turn
            playHumanTurn(reader, board);
            if (SuperFourUtils.hasWinner(board)) break;

            // Bot turn
            playBotTurn(board);
            if (SuperFourUtils.hasWinner(board)) break;

            System.out.println();
        }
    }

    private void playHumanTurn(BufferedReader reader, int[][] board) throws Exception {
        boolean turnTaken = false;

        while (!turnTaken) {
            System.out.println();
            System.out.print("Your turn! Pick a column between 1 and 7:");

            String inputCol = reader.readLine().trim();
            OptionalInt col = SuperFourUtils.getAndValidateColumnInput(inputCol);

            if (col.isEmpty()) {
                System.out.println("Invalid input! Enter a number between 1 and 7.");
                continue;
            }
            OptionalInt row = SuperFourUtils.dropPiece(board, col.getAsInt());
            if (row.isPresent()) {
                board[row.getAsInt()][col.getAsInt()] = PlayerEnum.HUMAN.id;
                turnTaken = true;
            } else {
                System.out.print("The column " +col + " is full!, choose another one.");
            }
        }
    }

    private void playBotTurn(int[][] board) throws Exception {
        int colBot = BotPlayer.play(board);
        OptionalInt rowBot = SuperFourUtils.dropPiece(board, colBot);
        if (rowBot.isPresent()) {
            int rowBotBoard = rowBot.getAsInt();
            board[rowBotBoard][colBot] = PlayerEnum.BOT.id;
            System.out.println("************************************************************");
            System.out.println("Bot plays column:" + (colBot + 1));
        }
    }

}
