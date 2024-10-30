package com.tco.requests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TestGameRequest {

    @Test
    @DisplayName("Johnh9 test: Test creating a game request")
    public void testCreateGameRequest() {
        GameRequest request = new GameRequest();
        request.setGameId("game123");
        request.setAction("create");
        request.setUsers(new String[]{"user1", "user2"});

        assertEquals("game123", request.getGameId());
        assertEquals("create", request.getAction());
        assertArrayEquals(new String[]{"user1", "user2"}, request.getUsers());
    }

    @Test
    @DisplayName("Johnh9 test: Test getting game status")
    public void testGetGameStatus() {
        GameRequest request = new GameRequest();
        request.setGameId("game123");
        request.setAction("getStatus");

        assertEquals("game123", request.getGameId());
        assertEquals("getStatus", request.getAction());
    }
}
