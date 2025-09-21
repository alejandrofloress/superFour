package org.games.superfour.enums;

public enum Player {
    EMPTY(0, "- "),
    HUMAN(1, "X "),
    BOT(2, "0 "); // (used 'O' instead of zero)

    public final int id;
    private final String symbol;

    Player(int id, String symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

    public static Player fromId(int id) {
        return switch (id) {
            case 1 -> HUMAN;
            case 2 -> BOT;
            default -> EMPTY;
        };
    }
}