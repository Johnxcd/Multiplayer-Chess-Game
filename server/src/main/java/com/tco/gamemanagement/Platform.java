package com.tco.gamemanagement;

import java.util.List;

import com.tco.database.Database;
import com.tco.gameplaying.Match;
import com.tco.usermanagement.Profile;
import java.util.logging.Logger;
import java.lang.Exception;

public class Platform {
    private Profile profile;
    private Match match;
    private static final Logger logger = Logger.getLogger(Platform.class.getName());

    public Platform() {
        this.profile = null; // New Platform shouldn't have any user logged in!
        this.match = null;   // New Platform shouldn't have an active game up!
    }
    
    public Profile getProfile() {
        return this.profile;
    }
    
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Match getMatch() {
        return this.match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    // Loop users to find the one with the matching email
    public User login(String email, String password) throws Exception {

        List<User> users = null;
        try{
        users = Database.getAllUsers();
        }
        catch(Exception e){
            logger.warning("Failed to get users from DB" + e.toString());
        }
        for (User user : users) {
            User authenticatedUser = user.authenticate(email, password);
            if (authenticatedUser != null) {
                return authenticatedUser;
            }
        }
        return null;
    }

    public void logout() {
        this.setProfile(null);
    }
}
