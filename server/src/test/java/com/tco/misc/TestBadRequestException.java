package com.tco.misc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TestBadRequestException {

    @Test
    @DisplayName("Johnh9 test: Test default constructor")
    public void testDefaultConstructor() {
        BadRequestException exception = new BadRequestException();
        assertNull(exception.getMessage());
    }

    @Test
    @DisplayName("Johnh9 test: Test message constructor")
    public void testMessageConstructor() {
        String message = "Bad request error";
        BadRequestException exception = new BadRequestException(message);
        assertEquals(message, exception.getMessage());
    }
}