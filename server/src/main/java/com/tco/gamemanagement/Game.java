package com.tco.gamemanagement;

import com.tco.misc.*;
import com.tco.gameplaying.Color;
import com.tco.gameplaying.Piece;
import com.tco.gameplaying.Rook;
import com.tco.gameplaying.Pawn;
import com.tco.gameplaying.Knight;
import com.tco.gameplaying.Bishop;
import com.tco.gameplaying.Queen;
import com.tco.gameplaying.King;

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

        // place rooks
        board[0][0] = new Rook(Color.WHITE, new int[]{0, 0});
        board[0][7] = new Rook(Color.WHITE, new int[]{0, 7});
        board[7][0] = new Rook(Color.BLACK, new int[]{7, 0});
        board[7][7] = new Rook(Color.BLACK, new int[]{7, 7});

        // place knights
        board[0][1] = new Knight(Color.WHITE, new int[]{0, 1});
        board[0][6] = new Knight(Color.WHITE, new int[]{0, 6});
        board[7][1] = new Knight(Color.BLACK, new int[]{7, 1});
        board[7][6] = new Knight(Color.BLACK, new int[]{7, 6});

        // place bishops
        board[0][2] = new Bishop(Color.WHITE, new int[]{0, 2});
        board[0][5] = new Bishop(Color.WHITE, new int[]{0, 5});
        board[7][2] = new Bishop(Color.BLACK, new int[]{7, 2});
        board[7][5] = new Bishop(Color.BLACK, new int[]{7, 5});

        // place queens
        board[0][3] = new Queen(Color.WHITE, new int[]{0, 3});
        board[7][3] = new Queen(Color.BLACK, new int[]{7, 3});

        // place kings
        board[0][4] = new King(Color.WHITE, new int[]{0, 4});
        board[7][4] = new King(Color.BLACK, new int[]{7, 4});
    }


    // public void sendNotification(User user){
    //     //nothing yet
    // }

}
