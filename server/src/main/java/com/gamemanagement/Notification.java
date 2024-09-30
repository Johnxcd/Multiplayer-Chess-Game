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

    public setRequestor(User requestor){
        this.requestor = requestor
    }

    public setRequested(User requested){
        this.requested = requested
    }

    public String getNotificationType(){
        return notificationType;
    }

    public setNotificationType(String notification){
        notificationType = notification;
    }

    public setGameStatus(String status){
        this.gameStatus = status;
    }

    public setGameOutcome(String outcome){
        this.gameOutcome = outcome;
    }
}
