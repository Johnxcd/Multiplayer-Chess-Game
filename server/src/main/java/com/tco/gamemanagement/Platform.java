package com.tco.gamemanagement;

import com.tco.usermanagement.Profile;
import com.tco.gameplaying.Match;

public class Platform {
    private Profile profile;
    private Match match;

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

    // private void login(String username, String password) {
    //     Profile authorizedUser = authenticate(username, password);
    //     if (authorizedUser == null) {
    //         // incorrect password / username combination (or user does not exist)
    //     } else {
    //         this.setProfile(authorizedUser);
    //     }
    // }

    public void logout() {
        this.setProfile(null);
    }
}
