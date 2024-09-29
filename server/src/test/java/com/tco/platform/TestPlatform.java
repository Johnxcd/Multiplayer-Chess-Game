package com.tco.platform;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlatform {

    private Platform platform;

    @BeforeEach
    public void createConfigurationForTestCases() {
        platform = new Platform();
    }
}