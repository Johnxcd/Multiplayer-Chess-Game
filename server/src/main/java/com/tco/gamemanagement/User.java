package com.tco.gamemanagement;

import java.util.List;

public class User implements Invitation{
    
  private static List<User> users = new ArrayList<>();
  private String username;
  
  public User(String username) {
      this.username = username;
      users.add(this);
    }

  public String getUsername() {
      return username;
  }

  public static void sendInvitation(String username) {
      for (User user : users) {
          if (user.getUsername().equals(username)) {
            user.onInvitation();
          }
      }
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
      for (User user : users) {
       //Do something
    }
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
