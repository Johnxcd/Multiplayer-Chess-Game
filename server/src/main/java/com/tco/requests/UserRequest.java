package com.tco.requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tco.gamemanagement.User;
import com.tco.misc.BadRequestException;

public class UserRequest extends Request {

    private static final transient Logger log = LoggerFactory.getLogger(UserRequest.class);

    private String action; // "register", "login", "updateProfile"
    private String email;
    private String password;
    private String userName;
    private User user;

    @Override
    public void buildResponse() throws BadRequestException {
        switch (action) {
            case "register":
                registerUser();
                break;
            case "login":
                loginUser();
                break;
            case "updateProfile":
                updateUserProfile();
                break;
            default:
                log.error("Unknown action: {}", action);
                throw new BadRequestException("Unknown action: " + action);
        }
        log.trace("buildResponse -> {}", this);
    }

    private void registerUser() {
        user = new User(userName);
        user.register(email, password);
        log.info("User registered with email: {}", user.getEmail());
    }

    private void loginUser() throws BadRequestException {
        log.info("Attempting to log in user with email: {}", email);
        for (User u : User.getUsers()) {
            log.info("Checking user: {}", u.getEmail());
            if (u.authenticate(email, password) != null) {
                user = u;
                log.info("User authenticated: {}", user.getEmail());
                return;
            }
        }
        log.error("Invalid email or password for user: {}", email);
        throw new BadRequestException("Invalid email or password");
    }

    private void updateUserProfile() throws BadRequestException {
        user = User.getUserByName(userName);
        if (user == null) {
            throw new BadRequestException("User not found: " + userName);
        }
        user.setEmail(email);
        user.getProfile().setPassword(password);
        user.updateProfile(user.getProfile());
    }

    public UserRequest() {
        this.requestType = "user";
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUser() {
        return user;
    }
}