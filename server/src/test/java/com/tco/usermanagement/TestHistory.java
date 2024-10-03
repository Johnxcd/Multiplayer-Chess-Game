package com.tco.usermanagement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHistory {

    private History history;

    @BeforeEach
    public void createHistoryForTestCases() {
        history = new History();
    }
}