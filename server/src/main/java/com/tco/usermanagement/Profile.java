package com.tco.usermanagement;

import com.tco.gamemanagement.User;
import com.tco.usermanagement.History;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.UUID;

public class Profile {
    protected String userName;
    protected String email;
    protected String password;
    protected String profileData;
    protected History historyData;
    protected String creationDate;
    protected UUID userId = null;

    public String getUserProfileData() {
        this.generateProfileData();
        return this.profileData;
    }

    public UUID getUserId(){
        return this.userId;
    }

    public void setUserId(UUID uuid){
        this.userId = uuid;
    }

    public void createUserId(){
        this.userId = UUID.randomUUID();
    }

    public History getHistory() {
        return this.historyData;
    }

    public void setHistory(History history) {
        this.historyData = history;
    }

    private void displayDataGUI() {

    }

    private void closeProfile() {

    }

    private void generateProfileData() {
        String overallStatus = "";
        overallStatus += "Profile Creation Date: " + getCreationDate() + "\n";

        overallStatus += "Wins: " + historyData.getRecord()[0] + "\n";
        overallStatus += "Losses: " + historyData.getRecord()[1] + "\n";
        overallStatus += "Draws: " + historyData.getRecord()[2] + "\n";
        overallStatus += "Ongoing: " + historyData.getRecord()[3] + "\n";

        this.profileData = overallStatus;
    }

    public String getCreationDate() {
        if(creationDate == null) {
            creationDate = getCurrentDate();
        }
        return creationDate;
    }

    public void setCreationDate(String time){
        this.creationDate = time;
    }

    public String getCurrentDate() {    
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);

    }    

    public String getUserName() {
        return this.userName;
      }
    
      public void setUserName(String userName) {
        this.userName = userName;
      }
    
      public String getEmail() {
        return email;
      }
    
      public void setEmail(String email) {
        this.email = email;
      }

      public void setPassword(String password){
        this.password = password;
      }

      public String getPassword(){
        return password;
      }
}
