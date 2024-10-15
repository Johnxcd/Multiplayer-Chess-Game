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
    
    public static Piece createPiece(PieceType type, Color color, int[] position){
        switch(type){
            case PAWN:
                return new PAWN(color, position);
            case ROOK:
                return new PAWN(color, position);
            case KNIGHT:
                return new PAWN(color, position);
            case KING:
                return new PAWN(color, position);
            case QUEEN:
                return new PAWN(color, position);
            case BISHOP:
                return new PAWN(color, position);
            default:
                throw new IllegalPieceException("Unknown piece type: " + type);
        }
    }
}
