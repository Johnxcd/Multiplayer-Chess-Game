package com.tco.gamemanagement;

import java.util.ArrayList;
import java.util.List;
import com.tco.misc.*;

public abstract class Game {
    
    ArrayList<User> users = new ArrayList<>();
    //Notification notify = new Notification;
    
    public Game(){
        //nothing yet
    }

    public void setUsers(ArrayList<User> users){
        this.users = users;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void trackHistory(ArrayList<User> users){
        //nothing yet
    }

    public void sendNotification(User user){
        //nothing yet
    }
}
