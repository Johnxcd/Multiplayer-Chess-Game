package com.tco.usermanagement;

import com.tco.gamemanagement.User;
import com.tco.usermanagement.History;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Profile {
    private User user;
    private String profileData;
    private History historyData;
    private String creationDate;

    public String getUserProfileData() {
        this.generateProfileData();
        return profileData;
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
}
