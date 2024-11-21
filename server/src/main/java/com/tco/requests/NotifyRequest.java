package com.tco.requests;

import com.tco.gamemanagement.User;
import com.tco.misc.BadRequestException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotifyRequest extends Request {
    private static final transient Logger log = LoggerFactory.getLogger(NotifyRequest.class);

    private String username;
    private User user;
    private HashMap<String, String> notifications;

    @Override
    public void buildResponse() throws BadRequestException {
        try {
            User user = User.getUserByName(username);
            notifications = notifyUser();
            log.trace("buildResponse -> {}", this);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }

    private HashMap<String, String> notifyUser() throws BadRequestException {
        //TODO: functionality to gather every notification
        //Notifications will be stored as ["Notification Type", "Additional Parameter"]
        //Examples: ["Invitation","Inviting User"] or ["MatchResult","Win"]  
        HashMap<String, String> userNotifs = new HashMap<String, String>();
        userNotifs.put("invitation", "test");
        return userNotifs;
    }

    //The below are test methods.
    public NotifyRequest() {
        this.requestType = "notify";
    }
}
