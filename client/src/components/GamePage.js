import React, { useEffect, useState } from 'react';
import { useServerSettings } from '../hooks/useServerSettings';
import '../static/styles/student-styles.scss'

import ChessBoard from '../../../images/ChessBoard/Chess_Board.png';
import BlackBishop from '../../../images/ChessBoard/Pieces/black-bishop.png';
import BlackKing from '../../../images/ChessBoard/Pieces/black-king.png';
import BlackKnight from '../../../images/ChessBoard/Pieces/black-knight.png';
import BlackPawn from '../../../images/ChessBoard/Pieces/black-pawn.png';
import BlackQueen from '../../../images/ChessBoard/Pieces/black-queen.png';
import BlackRook from '../../../images/ChessBoard/Pieces/black-rook.png';
import WhiteBishop from '../../../images/ChessBoard/Pieces/white-bishop.png';
import WhiteKing from '../../../images/ChessBoard/Pieces/white-king.png';
import WhiteKnight from '../../../images/ChessBoard/Pieces/white-knight.png';
import WhitePawn from '../../../images/ChessBoard/Pieces/white-pawn.png';
import WhiteQueen from '../../../images/ChessBoard/Pieces/white-queen.png';
import WhiteRook from '../../../images/ChessBoard/Pieces/white-rook.png';

export default function GamePage(props) {
	const [serverSettings, processServerConfigSuccess] = useServerSettings(props.showMessage);
	const [board, setBoard] = useState(initializeBoard());
    const [selectedPiece, setSelectedPiece] = useState(null);
	
	function initializeBoard() {
        // Define rows with specific pieces for both sides
        const initialBlackRow = [
            { type: 'rook', color: 'black' },
            { type: 'knight', color: 'black' },
            { type: 'bishop', color: 'black' },
            { type: 'queen', color: 'black' },
            { type: 'king', color: 'black' },
            { type: 'bishop', color: 'black' },
            { type: 'knight', color: 'black' },
            { type: 'rook', color: 'black' },
        ];
        const initialWhiteRow = [
            { type: 'rook', color: 'white' },
            { type: 'knight', color: 'white' },
            { type: 'bishop', color: 'white' },
            { type: 'queen', color: 'white' },
            { type: 'king', color: 'white' },
            { type: 'bishop', color: 'white' },
            { type: 'knight', color: 'white' },
            { type: 'rook', color: 'white' },
        ];
    
        // Define empty rows and pawns
        const emptyRow = Array(8).fill(null);
        const blackPawns = Array(8).fill({ type: 'pawn', color: 'black' });
        const whitePawns = Array(8).fill({ type: 'pawn', color: 'white' });
    
        // Assemble the board
        const board = [
            initialBlackRow,  // Black's main pieces
            blackPawns,       // Black's pawns
            ...Array(4).fill(emptyRow),  // Empty rows
            whitePawns,       // White's pawns
            initialWhiteRow,  // White's main pieces
        ];
    
        return board;
    }
    

    const handleMove = async (from, to) => {
        const moveRequest = {
            requestType: "move",
            uuid: "game-1234",
            from: from,
            to: to
        };
        const response = await sendAPIRequest(moveRequest, getOriginalServerUrl());
        if (response) {
            console.log("Move successful", response);
            // Update board state here
        } else {
            console.error("Move failed");
        }
    };

    const handleSquareClick = (row, col) => {
        if (selectedPiece) {
            //Ask if its valid

            // Move the piece
            const newBoard = board.map((r, rIndex) =>
                r.map((square, cIndex) => {
                    if (rIndex === row && cIndex === col) {
                        return selectedPiece.piece; // Place the selected piece here
                    }
                    if (rIndex === selectedPiece.row && cIndex === selectedPiece.col) {
                        return null; // Clear the old position
                    }
                    return square;
                })
            );
            setBoard(newBoard);
            setSelectedPiece(null); // Clear the selection
        } else if (board[row][col]) {
            // Select the piece
            setSelectedPiece({ piece: board[row][col], row, col });
        }
    };


	return (
		<div className='page'>
			<h1>GAME</h1>
			<button onClick={props.onBackButtonClick}> Go Back </button>
			<div className='chessboard'>
                {board.map((row, rowIndex) => (
                    <div key={rowIndex} className='chess-row'>
                        {row.map((square, colIndex) => (
                            <div
                                key={colIndex}
                                className={`chess-square ${(rowIndex + colIndex) % 2 === 0 ? 'light' : 'dark'}`}
                                onClick={() => handleSquareClick(rowIndex, colIndex)}
                            >
                                {square && (
                                    <img
                                        src={
                                            square.type === 'pawn'
                                                ? square.color === 'black'
                                                    ? BlackPawn
                                                    : WhitePawn
                                                : 
                                            square.type === 'rook'
                                                ? square.color === 'black'
                                                    ? BlackRook
                                                    : WhiteRook
                                                : 
                                            square.type === 'queen'
                                                ? square.color === 'black'
                                                    ? BlackQueen
                                                    : WhiteQueen
                                                : 
                                            square.type === 'bishop'
                                                ? square.color === 'black'
                                                    ? BlackBishop
                                                    : WhiteBishop
                                                : 
                                            square.type === 'knight'
                                                ? square.color === 'black'
                                                    ? BlackKnight
                                                    : WhiteKnight
                                                : 
                                            square.type === 'king'
                                                ? square.color === 'black'
                                                    ? BlackKing
                                                    : WhiteKing
                                                : null
                                        }
                                        alt={square.color + ' ' + square.type}
                                        className='chess-piece'
                                    />
                                )}
                            </div>
                        ))}
                    </div>
                ))}
            </div>
            {/* Chess Pieces */}
			<div className="chess-pieces">
            <img
				src={BlackRook}
				alt="Black Rook"
				className="black-king-statue"
				/>
				<img
				src={WhiteRook}
				alt="White Rook"
				className="white-king-statue"
				/>
                <img
				src={BlackRook}
				alt="Black Rook"
				className="black-queen-statue"
				/>
				<img
				src={WhiteRook}
				alt="White Rook"
				className="white-queen-statue"
				/>
			</div>
		</div>
	);
}


