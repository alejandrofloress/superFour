package org.games.superfour;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            SuperFour superFourGame = new SuperFour();
            superFourGame.runGame(reader);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
