package com.tco.gamemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TestGame{
    private Game game;

    private class GameTest extends Game{

    }

    @BeforeEach
    public void setUp() {
        game = new GameTest();
    }
}
