package com.tco.gamemanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.tco.usermanagement.Profile;
import com.tco.gameplaying.Match;
import com.tco.gamemanagement.Notification; 

public class User extends Profile implements Invitation{
    
  private static final Logger logger = Logger.getLogger(User.class.getName());
  private static List<User> users = new ArrayList<>();
  private List<Notification> notifications = new ArrayList<>();
  private List<Invitation> invitations = new ArrayList<>();
  private List<Match> matches = new ArrayList<>();

  public User(String username, String email, String password, String history, String creationDate, UUID userId) {
    super.username = username;
    super.email = email;
    super.password = password;
    super.history = history;
    super.creationDate = creationDate;

    if(super.userID != null){
      super.userID = userID;
    }

    users.add(this);
  }
  
  public static List<User> getUsers() {
    return users;
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
    super.email = email;
    super.password = password;
    logger.info("User registered with email: " + email);
  }

  public User authenticate(String email, String password) {
    if (super.email.equals(email) && super.password.equals(password)) {
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
    //only thing worth updating is history at this point
    super.history = profile.history;
    // Do something
    logger.info("Profile updated for user: " + username);
  }

  @Override
  public void acceptInvitation(Invitation invitation) {
    invitations.add(invitation);
    logger.info(invitation.inviteMessage + username);
  }

  @Override
  public void rejectInvitation(Invitation invitation) {
    // Do something
    logger.info(invitation.rejectedMessage + username);
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
