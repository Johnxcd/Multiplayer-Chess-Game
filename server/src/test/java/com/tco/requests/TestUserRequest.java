package com.tco.requests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.tco.misc.BadRequestException;
import com.tco.gamemanagement.User;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TestUserRequest {

    private static final Logger log = Logger.getLogger(TestUserRequest.class.getName());

    @BeforeEach
    public void setUp() {
        User.getUsers().clear();
    }

    @Test
    @DisplayName("Johnh9 test: Test user registration")
    public void testRegisterUser() throws BadRequestException {
        UserRequest request = new UserRequest();
        request.setAction("register");
        request.setUserName("user1");
        request.setEmail("user1@example.com");
        request.setPassword("password123");

        request.buildResponse();

        assertNotNull(request.getUser());
        assertEquals("user1", request.getUser().getUserName());
        assertEquals("user1@example.com", request.getUser().getEmail());
    }

    @Test
    @DisplayName("Johnh9 test: Test user login")
    public void testLoginUser() throws BadRequestException {
        UserRequest registerRequest = new UserRequest();
        registerRequest.setAction("register");
        registerRequest.setUserName("user1");
        registerRequest.setEmail("user1@example.com");
        registerRequest.setPassword("password123");
        registerRequest.buildResponse();

        UserRequest loginRequest = new UserRequest();
        loginRequest.setAction("login");
        loginRequest.setEmail("user1@example.com");
        loginRequest.setPassword("password123");
        loginRequest.buildResponse();

        assertNotNull(loginRequest.getUser());
        assertEquals("user1@example.com", loginRequest.getUser().getEmail());
    }

    @Test
    @DisplayName("sam25 test: Test user login fails")
    public void testLoginUserFails() {
        try{
        UserRequest registerRequest = new UserRequest();
        registerRequest.setAction("register");
        registerRequest.setUserName("user1");
        registerRequest.setEmail("user1@example.com");
        registerRequest.setPassword("password123");
        registerRequest.buildResponse();

        
        UserRequest loginRequest = new UserRequest();
        loginRequest.setAction("login");
        loginRequest.setEmail("user1@example.com");
        loginRequest.setPassword("badPassword");
        loginRequest.buildResponse();
        // assertThrows(Exception.class, loginRequest.getUser());
        assertNull(loginRequest.getUser());
        }
        catch(Exception E){
          
        }
    }

    @Test
    @DisplayName("Johnh9 test: Test updating user profile")
    public void testUpdateUserProfile() throws BadRequestException {
        UserRequest registerRequest = new UserRequest();
        registerRequest.setAction("register");
        registerRequest.setUserName("user1");
        registerRequest.setEmail("user1@example.com");
        registerRequest.setPassword("password123");
        registerRequest.buildResponse();

        UserRequest updateRequest = new UserRequest();
        updateRequest.setAction("updateProfile");
        updateRequest.setUserName("user1");
        updateRequest.setEmail("newemail@example.com");
        updateRequest.setPassword("newpassword123");
        updateRequest.buildResponse();

        assertNotNull(updateRequest.getUser());
        assertEquals("newemail@example.com", updateRequest.getUser().getEmail());
    }
}