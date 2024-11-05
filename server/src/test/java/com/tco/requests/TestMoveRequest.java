package com.tco.requests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.tco.gameplaying.Match;
import com.tco.gameplaying.Rules;
import com.tco.gamemanagement.User;
import com.tco.misc.BadRequestException;
import java.util.HashMap;

public class TestMoveRequest {

    @Test
    @DisplayName("johnh9 test: Test making a valid move")
    public void testValidMove() {
        // temp match storage
        MoveRequest.setMatchStorage(new HashMap<>());
        User[] users = {new User("user1"), new User("user2")};
        Match match = new Match(users, new Rules());
        MoveRequest.getMatchStorage().put(match.getMatchID(), match);

        // move request
        MoveRequest request = new MoveRequest();
        request.setUuid(match.getMatchID());
        request.setFrom(new int[]{1, 0});
        request.setTo(new int[]{2, 0});

        // response
        try {
            request.buildResponse();
            assertNotNull(request.getPossibleMoves());
        } catch (BadRequestException e) {
            fail("Move should be valid");
        }
    }

    @Test
    @DisplayName("johnh9 test: Test making an invalid move")
    public void testInvalidMove() {
        // temp match storage
        MoveRequest.setMatchStorage(new HashMap<>());
        User[] users = {new User("user1"), new User("user2")};
        Match match = new Match(users, new Rules());
        MoveRequest.getMatchStorage().put(match.getMatchID(), match);

        // move request
        MoveRequest request = new MoveRequest();
        request.setUuid(match.getMatchID());
        request.setFrom(new int[]{1, 0});
        request.setTo(new int[]{3, 0}); // invalid for pawn

        // response
        assertThrows(BadRequestException.class, request::buildResponse);
    }
}
