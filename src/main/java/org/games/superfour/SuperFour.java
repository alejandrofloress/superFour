package org.games.superfour;

import org.games.superfour.enums.PlayerEnum;
import java.io.BufferedReader;

import static org.games.superfour.utils.HandleTurn.playBotTurn;
import static org.games.superfour.utils.HandleTurn.playHumanTurn;
import static org.games.superfour.utils.SuperFourUtils.*;


public class SuperFour {
    public void runGame(BufferedReader reader) throws Exception {
        boolean gameIsActive = true;
        int totalMoves = 0;
        int[][] board = getBoard();
        while (gameIsActive) {
            printBoard(board);
            // User turn
            CellMove humanCellMove = playHumanTurn(reader, board);
            if ( totalMoves >= 3) {
                if (checkForWinner(board, humanCellMove, PlayerEnum.HUMAN)) break;
            }

            // Bot turn
            CellMove botCellMove = playBotTurn(board);
            if ( totalMoves >= 3) {
                if (checkForWinner(board, botCellMove, PlayerEnum.BOT) ) break;
            }
            totalMoves++;
            if (!shouldContinue(totalMoves)) {
                gameIsActive = false;
            }
            System.out.println();
        }
    }


}
