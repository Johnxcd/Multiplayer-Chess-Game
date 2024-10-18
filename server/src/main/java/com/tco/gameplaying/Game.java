package com.tco.gameplaying;

import com.tco.misc.*;
import com.tco.gamemanagement.User;

public abstract class Game {
    
    private User[] users;
    protected Piece[][] board;
    //Notification notify = new Notification;
    
    public Game(User[] users){
        this.users = new User[]{users[0], users[1]};
        createBoard();
    }

    public abstract Piece getPieceAt(int[] position);
    public abstract boolean isPositionOnBoard(int[] position);

    public User[] getUsers() { return users; }
    public Piece[][] getBoard() { return this.board; }

    
    private void createBoard() {
        // initialize the board with pieces in starting positions
        board = new Piece[8][8];

        // place pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.WHITE, new int[]{1, i});
            board[6][i] = new Pawn(Color.BLACK, new int[]{6, i});
        }
        
        board[0][0] = new Rook(Color.WHITE, new int[]{0, 0});
        board[0][7] = new Rook(Color.WHITE, new int[]{0, 7});
        board[7][0] = new Rook(Color.BLACK, new int[]{7, 0});
        board[7][7] = new Rook(Color.BLACK, new int[]{7, 7});
        board[0][1] = new Knight(Color.WHITE, new int[]{0, 1});
        board[0][6] = new Knight(Color.WHITE, new int[]{0, 6});
        board[7][1] = new Knight(Color.BLACK, new int[]{7, 1});
        board[7][6] = new Knight(Color.BLACK, new int[]{7, 6});
        // add other pieces
    }

    // public void sendNotification(User user){
    //     //nothing yet
    // }

}
