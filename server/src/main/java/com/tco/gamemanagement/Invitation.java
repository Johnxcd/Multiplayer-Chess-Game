package com.tco.gamemanagement;
import com.tco.gameplaying.Match;

interface Invitation extends Notification{
    public String inviteMessage = "Invitation accepted by user: ";
    public String rejectedMessage = "Invitation rejected by user: ";
    // private Notification notification; //NEED TO GET NOTIFICATION

    public void sendNotification(User user);

    public void onInvitation();

    public void acceptInvitation(Invitation invitation);

    public void rejectInvitation(Invitation invitation);

    @Override
    public void notifyAllPlayers();
}
