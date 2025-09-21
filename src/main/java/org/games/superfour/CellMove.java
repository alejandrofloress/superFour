package org.games.superfour;

public class CellMove {
    private final int row;
    private final int col;

    public CellMove(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}