package com.tco.usermanagement;

import com.tco.gamemanagement.User;
import com.tco.usermanagement.History;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.UUID;

public class Profile {
    private String username;
    private String email;
    private String password;
    private String profileData;
    private History historyData;
    private String creationDate;
    private UUID userId = null;

    public String getUserProfileData() {
        this.generateProfileData();
        return profileData;
    }

    public UUID getUserId(){
        return userId;
    }

    public History getHistory() {
        return historyData;
    }

    public void setHistroy(History history) {
        historyData = history;
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

    public String getCurrentDate() {    
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);

    }    

    public String getUsername() {
        return userName;
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
}
