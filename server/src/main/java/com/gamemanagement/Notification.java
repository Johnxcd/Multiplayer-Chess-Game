package com.tco.gamemanagement;

import com.tco.misc.*;

public class Notification {

    private String rejectionStatus = null;
    private User requestor = null;
    private User requested = null;
    private String gameOutcome = null;
    private String gameStatus = null;
    private String notificationType = null;
    
    public Notification(){
        //nothing yet
    }

    public void setRequestor(User requestor){
        this.requestor = requestor;
    }

    public void setRequested(User requested){
        this.requested = requested;
    }

    public String getNotificationType(){
        return notificationType;
    }

    public void setNotificationType(String notification){
        notificationType = notification;
    }

    public void setGameStatus(String status){
        this.gameStatus = status;
    }

    public void setGameOutcome(String outcome){
        this.gameOutcome = outcome;
    }
}
