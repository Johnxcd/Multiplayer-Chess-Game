package com.tco.gameplaying;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import com.tco.gamemanagement.User;
import com.tco.gamemanagement.GameStatus;

public class TestRules {
    private Rules rules;
    private Match game;
    private Move move;
    private User user1, user2;
    private User[] users;

    @BeforeEach
    public void setUp() {
        rules = new Rules();
        user1 = new User("user1");
        user2 = new User("user2");
        users = new User[]{user1, user2};
        game = new Match(users, rules);
    }

    @Test
    @DisplayName("Test Move Validation")
    public void testValidateMove() {
        // move from (1,0) to (2,0)
        move = new Move(new int[]{1, 0}, new int[]{2, 0});
        assertTrue(rules.validateMove(move, game));

        // invalid move example
        move = new Move(new int[]{1, 0}, new int[]{3, 0});
        assertFalse(rules.validateMove(move, game));
    }

    @Test
    @DisplayName("johnh9 test: Test Determine Turn Order")
    public void testDetermineTurnOrder() {
        assertEquals(user1, rules.determineTurnOrder(users));
    }

    @Test
    @DisplayName("johnh9 test: Test Game Status Check")
    public void testCheckGameStatus() {
        assertEquals(GameStatus.ONGOING, rules.checkGameStatus(game, game.getBoard()));
    }
}
