package org.games.superfour.bot;

import org.games.superfour.CellMove;
import org.games.superfour.enums.PlayerEnum;
import org.games.superfour.utils.WinnerChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.ThreadLocalRandom;

import static org.games.superfour.constant.BoardSizeConstant.COLS;
import static org.games.superfour.utils.SuperFourUtils.getAvailableRow;

public class BotPlayer {
    public static CellMove play(int[][] board) {
        Optional<CellMove> winner = pickMove(board);
        if (winner.isPresent()) {
            return winner.get();
        }
        return playRandomMove( board);
    }

    public static Optional<CellMove> pickMove(int[][] board) {
        for (int col = 0; col < COLS; col++) {
            // find first empty row in this column
            OptionalInt row = getAvailableRow(board, col);

            if (row.isEmpty()) {
                continue; // column full
            }
            CellMove move = new CellMove(row.getAsInt(), col);

            // simulate move
            board[move.getRow()][move.getCol()] = PlayerEnum.BOT.id;
            boolean wins = WinnerChecker.hasWinner(board, move);
            // undo move
            board[move.getRow()][move.getCol()] = 0;

            if (wins) {
                // play winning move
                return Optional.of(move);
            }
        }

        return Optional.empty();
    }

    public static CellMove playRandomMove(int[][] board) {
        // collect all non-full columns
        List<Integer> availableCols = new ArrayList<>();
        for (int col = 0; col < COLS; col++) {
            OptionalInt row = getAvailableRow(board, col);
            if (row.isPresent()) {
                availableCols.add(col);
            }
        }

        if (availableCols.isEmpty()) {
            throw new IllegalStateException("No moves available: board is full");
        }
        // pick a random column from the list
        int randomCol = availableCols.get(ThreadLocalRandom.current().nextInt(availableCols.size()));
        OptionalInt row = getAvailableRow(board, randomCol);
        if (row.isPresent()) {
            return new CellMove(row.getAsInt(), randomCol);
        }
        throw new IllegalStateException("No moves available: board is full");

    }

}
