package com.tco.gamemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TestNotification{
    private Notification notify;

    @BeforeEach
    public void setUp() {
        notify = new Notification();
    }
}
