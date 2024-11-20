package com.tco.misc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TestIllegalPieceException {

    @Test
    @DisplayName("Johnh9 tests: Test message constructor")
    public void testMessageConstructor() {
        String message = "Illegal piece error";
        IllegalPieceException exception = new IllegalPieceException(message);
        assertEquals(message, exception.getMessage());
    }
}