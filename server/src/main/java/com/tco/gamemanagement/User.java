package com.tco.gamemanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.tco.usermanagement.Profile;
import com.tco.gameplaying.Match;
import com.tco.gamemanagement.Notification; 

public class User implements Invitation{
    
  private static final Logger logger = Logger.getLogger(User.class.getName());
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

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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
    logger.info("User registered with email: " + email);
  }

  public User authenticate(String email, String password) {
    if (this.email.equals(email) && this.password.equals(password)) {
        logger.info("User authenticated successfully.");
        return this;
    } else {
        logger.warning("Authentication failed.");
        return null;
    }
  }

  public void viewProfile() {
    // Do something
    logger.info("Viewing profile for user: " + username);
  }

  public void updateProfile(Profile profile) {
    this.profile = profile;
    // Do something
    logger.info("Profile updated for user: " + username);
  }

  public void acceptInvitation(Invitation invitation) {
    invitations.add(invitation);
    logger.info("Invitation accepted by user: " + username);
  }

  public void rejectInvitation(Invitation invitation) {
    // Do something
    logger.info("Invitation rejected by user: " + username);
  }

  public void joinMatch(Match match) {
    matches.add(match);
    logger.info("User " + username + " joined match.");
  }

  public void quitMatch(Match match) {
    matches.remove(match);
    logger.info("User " + username + " quit match.");
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
