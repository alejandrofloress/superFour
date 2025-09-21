package org.games.superfour;


import org.games.superfour.enums.PlayerEnum;
import org.games.superfour.utils.SuperFourUtils;

import java.io.BufferedReader;

import static org.games.superfour.utils.HandleTurn.playBotTurn;
import static org.games.superfour.utils.HandleTurn.playHumanTurn;
import static org.games.superfour.utils.SuperFourUtils.checkForWinner;
import static org.games.superfour.utils.SuperFourUtils.printBoard;


public class SuperFour {
    public void runGame(BufferedReader reader) throws Exception {
        boolean gameIsActive = true;
        int[][] board = SuperFourUtils.getBoard();
        while (gameIsActive) {
            printBoard(board);
            // User turn
            CellMove humanCellMove = playHumanTurn(reader, board);
            if (checkForWinner(board, humanCellMove, PlayerEnum.HUMAN)) break;

            // Bot turn
            CellMove botCellMove = playBotTurn(board);
            if (checkForWinner(board, botCellMove, PlayerEnum.BOT)) break;

            System.out.println();
        }
    }


}
