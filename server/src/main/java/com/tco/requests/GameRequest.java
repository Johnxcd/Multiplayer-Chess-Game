package com.tco.requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tco.gamemanagement.User;
import com.tco.gamemanagement.GameStatus;
import com.tco.gameplaying.Match;
import com.tco.gameplaying.Rules;
import com.tco.misc.BadRequestException;
import java.util.HashMap;
import java.util.Map;

public class GameRequest extends Request {

    private static final transient Logger log = LoggerFactory.getLogger(GameRequest.class);

    private String gameId;
    private String action; //"create", "getStatus"
    private String[] users;
    private static Map<String, Match> matchStorage = new HashMap<>(); // in-memory storage for matches could be changed to database functions

    @Override
    public void buildResponse() throws BadRequestException {
        switch (action) {
            case "create":
                createGame();
                break;
            case "getStatus":
                getGameStatus();
                break;
            default:
                log.error("Unknown action: {}", action);
                throw new BadRequestException("Unknown action: " + action);
        }
        log.trace("buildResponse -> {}", this);
    }

    private void createGame() {
        User[] gameUsers = new User[users.length];
        for (int i = 0; i < users.length; i++) {
            gameUsers[i] = new User(users[i]);
        }
        Match newMatch = new Match(gameUsers, new Rules());
        this.gameId = newMatch.getMatchID();
        // using in-memory storage, using the database might work better 
        matchStorage.put(this.gameId, newMatch);
    }

    private void getGameStatus() throws BadRequestException {
        Match match = matchStorage.get(gameId);
        if (match != null) {
            this.users = new String[]{match.getUsers()[0].getUsername(), match.getUsers()[1].getUsername()};
        } else {
            throw new BadRequestException("Game not found: " + gameId);
        }
    }

    public GameRequest() {
        this.requestType = "game";
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }
}
