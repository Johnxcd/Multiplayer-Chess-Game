package com.tco.gamemanagement;

import java.util.List;

public class User implements Invitation{
    
    private String username;

    public User(String username){
      this.username = username;
    }

    /*
    private Profile profile;
    
    private String email;
    private String password;
    private List<Notification> notifications;
    private List<Invitation> invitations;
    private List<Match> matches;

      Register a new user with email and password
    public void register(String email, String password) {
    }

    // Authenticate user with email and password
    public void authenticate(String email, String password) {
    }

    // View user profile
    public void viewProfile() {
    }

    // Update user profile
    public void updateProfile(Profile profile) {
    }

    // Accept an invitation
    public void acceptInvitation(Invitation invitation) {
    }

    // Reject an invitation
    public void rejectInvitation(Invitation invitation) {
    }

    // Join a match
    public void joinMatch(Match match) {
    }

    // Quit a match
    public void quitMatch(Match match) {
    }
    */
    
    @Override
    public void notifyAllPlayers(){
      //Nothing yet
    }

    @Override
    public void sendNotification(User user){
      //Nothing yet
    }

    //Check if this call to invination is for myself, do something with the invite
    @Override
    public void onInvitation(String username){
      if(this.username == username){
        //Do something with the invite
      }
      else{
        //Not an Invite this user
      }
    }
}
