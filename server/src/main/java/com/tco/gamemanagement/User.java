package com.tco.gamemanagement;

import java.util.ArrayList;
import java.util.List;
import com.tco.usermanagement.Profile;
import com.tco.gameplaying.Match;
import com.tco.gamemanagement.Notification; 

public class User implements Invitation{
    
  private static List<User> users = new ArrayList<>();
  private String username;
  private String email;
  private String password;
  private Profile profile;
  private List<Notification> notifications = new ArrayList<>();
  private List<Invitation> invitations = new ArrayList<>();
  private List<Match> matches = new ArrayList<>();

  public User(String username) {
      this.username = username;
      users.add(this);
    }

  public String getUsername() {
      return username;
  }

  public static List<User> getUsers() {
    return users;
  }

  public Profile getProfile() {
    return this.profile;
  }

  public List<Match> getMatches() {
    return matches;
  }
  
  public List<Invitation> getInvitations() {
      return invitations;
  }


  public static void sendInvitation(String username) {
      for (User user : users) {
          if (user.getUsername().equals(username)) {
            user.onInvitation();
          }
      }
  }

  public void register(String email, String password) {
    this.email = email;
    this.password = password;
    System.out.println("User registered with email: " + email);
  }

  public User authenticate(String email, String password) {
    if (this.email.equals(email) && this.password.equals(password)) {
        System.out.println("User authenticated successfully.");
        return this;
    } else {
        System.out.println("Authentication failed.");
        return null;
    }
  }

  public void viewProfile() {
    // Do something
    System.out.println("Viewing profile for user: " + username);
  }

  public void updateProfile(Profile profile) {
    this.profile = profile;
    // Do something
    System.out.println("Profile updated for user: " + username);
  }

  public void acceptInvitation(Invitation invitation) {
    invitations.add(invitation);
    System.out.println("Invitation accepted by user: " + username);
  }

  public void rejectInvitation(Invitation invitation) {
    // Do something
    System.out.println("Invitation rejected by user: " + username);
  }

  public void joinMatch(Match match) {
    matches.add(match);
    System.out.println("User " + username + " joined match.");
  }

  public void quitMatch(Match match) {
    matches.remove(match);
    System.out.println("User " + username + " quit match.");
  }

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

  //do something with the invite
  @Override
  public void onInvitation(){
    
  }
}
