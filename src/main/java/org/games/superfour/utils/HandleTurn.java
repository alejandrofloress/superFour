package org.games.superfour.utils;

import org.games.superfour.CellMove;
import org.games.superfour.bot.BotPlayer;
import org.games.superfour.enums.PlayerEnum;

import java.io.BufferedReader;
import java.util.OptionalInt;

import static org.games.superfour.utils.SuperFourUtils.dropPiece;
import static org.games.superfour.utils.SuperFourUtils.getAndValidateColumnInput;

public class HandleTurn {
    public static CellMove playHumanTurn(BufferedReader reader, int[][] board) throws Exception {
        boolean turnTaken = false;
        int rowMove = 0;
        int colMove = 0;

        while (!turnTaken) {
            System.out.println();
            System.out.print("Your turn! Pick a column between 1 and 7:");

            String inputCol = reader.readLine().trim();
            OptionalInt col = getAndValidateColumnInput(inputCol);

            if (col.isEmpty()) {
                System.out.println("Invalid input! Enter a number between 1 and 7.");
                continue;
            }
            OptionalInt row = dropPiece(board, col.getAsInt());
            if (row.isPresent()) {
                rowMove =  row.getAsInt();
                colMove = col.getAsInt();
                board[rowMove][colMove] = PlayerEnum.HUMAN.id;
                turnTaken = true;

            } else {
                System.out.print("The column " +col + " is full!, choose another one.");
            }
        }
        return new CellMove(rowMove, colMove);
    }

    public static CellMove playBotTurn(int[][] board) {
        int rowBotBoard = 0;
        int colBot = BotPlayer.play(board);
        OptionalInt rowBot = dropPiece(board, colBot);
        if (rowBot.isPresent()) {
            rowBotBoard = rowBot.getAsInt();
            board[rowBotBoard][colBot] = PlayerEnum.BOT.id;
            System.out.println("************************************************************");
            System.out.println("Bot plays column:" + (colBot + 1));
        }
        return new CellMove(rowBotBoard, colBot);
    }

}
