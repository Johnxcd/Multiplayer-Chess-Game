package com.tco.gamemanagement;
import com.tco.gameplaying.Match;

interface Invitation extends Notification{
    public String inviteMessage = "A player has invited you to a new game.";
    public String rejectedMessage = "A player has rejected an invitation.";
    // private Notification notification; //NEED TO GET NOTIFICATION

    public void sendNotification(User user);

    public void onInvitation();

    public void acceptInvitation(Invitation invitation);

    public void rejectInvitation(Invitation invitation);

    @Override
    public void notifyAllPlayers();
}
