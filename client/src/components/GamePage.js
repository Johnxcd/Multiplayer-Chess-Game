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
        // Initialize a simple chessboard state with pawns and empty squares for demo purposes
        const emptyRow = Array(8).fill(null);
        const board = [
            Array(8).fill({ type: 'pawn', color: 'black' }), // Black pawns
            ...Array(6).fill(emptyRow), // Empty rows
            Array(8).fill({ type: 'pawn', color: 'white' }) // White pawns
        ];
        return board;
    }

    const handleSquareClick = (row, col) => {
        if (selectedPiece) {
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
		</div>
	);
}


