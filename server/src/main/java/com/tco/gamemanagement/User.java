package com.tco.gamemanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.UUID;
import com.tco.usermanagement.History;
import com.tco.usermanagement.Profile;
import com.tco.gameplaying.Match;
import com.tco.gamemanagement.Notification; 
import com.tco.database.Database;

public class User implements Invitation{
    
  private static final Logger logger = Logger.getLogger(User.class.getName());
  private static List<User> users = new ArrayList<>();
  private List<Notification> notifications = new ArrayList<>();
  private List<Invitation> invitations = new ArrayList<>();
  private List<Match> matches = new ArrayList<>();
  private Profile profile;

  public User(String userName){
    if(profile == null){
      profile = new Profile();
      profile.setHistory(new History());
      profile.setCreationDate(profile.getCreationDate());
      profile.createUserId();
    }

    this.profile.setUserName(userName);
    users.add(this);
  }

  public void setProfile(Profile profile){
    this.profile = profile;
  }

  public Profile getProfile(){
    return profile;
  }

  public void setUsername(String username) {
    this.profile.setUserName(username);
  }

  public String getUserName() {
    return this.profile.getUserName();
  }

  public String getEmail() {
    return this.profile.getEmail();
  }

  public void setEmail(String email) {
    this.profile.setEmail(email);
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

  public static void sendInvitation(String userName) {
      for (User user : users) {
          if (user.getUserName().equals(userName)) {
            user.onInvitation();
          }
      }
  }

  public static User getUserByName(String userName) {
    for (User user : users) {
        if (user.getUserName().equals(userName)) {
          return user;
        }
    }
    return null;
}

  public void register(String email, String password) {
    this.profile.setEmail(email);
    this.profile.setPassword(password);

    if(this.profile.getUserId() == null){
      this.profile.setUserId(UUID.randomUUID());
    }
    User findUser = Database.getUserById(this.profile.getUserId());

    if( findUser == null){
      Database.addUserDB(this);
    }
    
    logger.info("User registered with email: " + email);
  }

  public User authenticate(String email, String password) {
    try{
    List<User> users = Database.getAllUsers();
    }
    catch (Exception e){
      logger.warning("Failed to get users from DB" + e);
    }
    for(User user : users){
    if (user.profile.getEmail().equals(email) && user.profile.getPassword().equals(password)) {
        logger.info("User authenticated successfully.");
        return user;
    }
   }
      logger.warning("Authentication failed.");
      return null;
  }

  public void viewProfile() {
    // Do something
    logger.info("Viewing profile for user: " + getUserName());
  }

  public void updateProfile(Profile profile) {
    //only thing worth updating is history at this point
    this.profile = profile;
    // Do something
    logger.info("Profile updated for user: " + getUserName());
  }

  @Override
  public void acceptInvitation(Invitation invitation) {
    invitations.add(invitation);
    logger.info(invitation.inviteMessage + getUserName());
  }

  @Override
  public void rejectInvitation(Invitation invitation) {
    // Do something
    logger.info(invitation.rejectedMessage + getUserName());
  }

  public void joinMatch(Match match) {
    matches.add(match);
    logger.info("User " + getUserName() + " joined match.");
  }

  public void quitMatch(Match match) {
    matches.remove(match);
    logger.info("User " + getUserName() + " quit match.");
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
