package org.games.superFour.utils;


import org.games.superfour.utils.SuperFourUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SuperFourUtilsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        // Capture output
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testPrintBoard() {
        int[][] board = new int[6][7]; // all zeros

        SuperFourUtils.printBoard(board);

        String output = outContent.toString();
        assertTrue(output.contains("-"), "Should contain empty cells");
        assertTrue(output.contains("1 2 3 4 5 6 7"), "Should contain column numbers");

    }

    @Test
    void testValidInputs() {
        assertEquals(OptionalInt.of(0), SuperFourUtils.getAndValidateColumnInput("1"));
        assertEquals(OptionalInt.of(6), SuperFourUtils.getAndValidateColumnInput("7"));
        assertEquals(OptionalInt.of(3), SuperFourUtils.getAndValidateColumnInput("4"));
    }

    @Test
    void testInvalidInputs() {
        assertEquals(OptionalInt.empty(), SuperFourUtils.getAndValidateColumnInput("0"));
        assertEquals(OptionalInt.empty(), SuperFourUtils.getAndValidateColumnInput("8"));
        assertEquals(OptionalInt.empty(), SuperFourUtils.getAndValidateColumnInput("-2"));
        assertEquals(OptionalInt.empty(), SuperFourUtils.getAndValidateColumnInput("abc"));
        assertEquals(OptionalInt.empty(), SuperFourUtils.getAndValidateColumnInput(""));
    }
}
