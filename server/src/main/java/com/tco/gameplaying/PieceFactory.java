package com.tco.gameplaying;

import com.tco.gameplaying.Piece;
import com.tco.gameplaying.PieceType;
import com.tco.misc.IllegalPieceException;
import com.tco.gameplaying.Rook;
import com.tco.gameplaying.King;
import com.tco.gameplaying.Queen;
import com.tco.gameplaying.Pawn;
import com.tco.gameplaying.Bishop;
import com.tco.gameplaying.Knight;

public class PieceFactory{
    
    public static Piece createPiece(PieceType type, Color color, int[] position) throws IllegalPieceException{
        switch(type){
            case PAWN:
                return new Pawn(color, position);
            case ROOK:
                return new Rook(color, position);
            case KNIGHT:
                return new Knight(color, position);
            case KING:
                return new King(color, position);
            case QUEEN:
                return new Queen(color, position);
            case BISHOP:
                return new Bishop(color, position);
            default:
                throw new IllegalPieceException("Unknown piece type: " + type);
        }
    }
}
