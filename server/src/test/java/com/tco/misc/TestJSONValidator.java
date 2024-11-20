package com.tco.misc;

import com.tco.requests.ConfigRequest;
import com.tco.requests.GameRequest;
import com.tco.requests.MoveRequest;
import com.tco.requests.UserRequest;

import java.lang.reflect.Type;

import org.everit.json.schema.SchemaException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class TestJSONValidator {

    private void test(String request, Type type, boolean valid) {
        try {
            JSONValidator.validate(request, type);
            assertTrue(valid);
        } catch ( Exception e ) {
            assertFalse(valid);
        }
    }

    @Test
    @DisplayName("base: Config request should fail schema validation")
    public void testConfigRequestFail() {
        test("{}", ConfigRequest.class, false);
    }

    @Test
    @DisplayName("base: Config request should pass schema validation")
    public void testConfigRequestPass() {
        test("{\"requestType\":\"config\",\"features\":[\"config\"]}", ConfigRequest.class, true);
    }

    @Test
    @DisplayName("base: There should be no schema for the JSONValidator class")
    public void testMissingSchema() {
        test("", JSONValidator.class, false);
    }

    @Test
    @DisplayName("ept: Game Request should pass schema validation")
    public void testGameRequestPass() {
        test("{\"requestType\":\"game\",\"id\":\"0\",\"action\":\"create\",\"users\":[\"\"]}", GameRequest.class, true);
    }

    @Test
    @DisplayName("ept: Game Request should fail schema validation")
    public void testGameRequestFail() {
        test("", GameRequest.class, false);
    }

    @Test
    @DisplayName("ept: Move Request should pass schema validation")
    public void testMoveRequestPass() {
        test("{\"requestType\":\"move\",\"uuid\":\"testid\",\"from\":[0,0],\"to\":[0,0]}", MoveRequest.class, true);
    }

    @Test
    @DisplayName("ept: Move Request should fail schema validation")
    public void testMoveRequestFail() {
        test("", MoveRequest.class, false);
    }

    @Test
    @DisplayName("ept: User Request should pass schema validation")
    public void testUserRequestPass() {
        test("{\"requestType\":\"user\",\"action\":\"anystring\"}", UserRequest.class, true);
    }

    @Test
    @DisplayName("ept: User Request should fail schema validation")
    public void testUserRequestFail() {
        test("", UserRequest.class, false);
    }

    @Test
    @DisplayName("base: An invalid schema results in validate() failing")
    public void testInvalidSchema() {
        try (MockedStatic<SchemaLoader> mockedSchemaLoader = mockStatic(SchemaLoader.class)) {
            mockedSchemaLoader.when(() -> SchemaLoader.load(any(JSONObject.class)))
                    .thenThrow(SchemaException.class);

            test("{\"requestType\":\"config\"}", ConfigRequest.class, false);
        }
    }
}
