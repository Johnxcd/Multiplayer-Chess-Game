package com.tco.gamemanagement;

interface Invitation extends Notification{
    public String inviteMessage = null;
    public String rejectedMessage = null;
    // private Notification notification; //NEED TO GET NOTIFICATION

    public void sendNotification(User user);

    public void onInvitation();

    // public void sendInviteToPlayer(User user, Match match) { //NEED TO GET USER && MATCH

    // }

    // public void rejectedInvitation() {
        
    // }
}
