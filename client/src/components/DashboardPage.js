import React, { useState } from 'react';
import { useServerSettings } from '../hooks/useServerSettings';
import ProfileButton from '../../../images/ProfileButton.png';
import '../static/styles/student-styles.scss';
import BlackKing from '../../../images/ChessBoard/Pieces/black-king.png';
import WhiteKing from '../../../images/ChessBoard/Pieces/white-king.png';
import WhiteQueen from '../../../images/ChessBoard/Pieces/white-queen.png';
import BlackQueen from '../../../images/ChessBoard/Pieces/black-queen.png';

export default function DashboardPage(props) {
    const [serverSettings, processServerConfigSuccess] = useServerSettings(props.showMessage);
    const [showProfileCard, setShowProfileCard] = useState(false);

    const toggleProfileCard = () => {
        setShowProfileCard(!showProfileCard);
    };

    return (
        <div className="dashboard-page">
			{/* Dashboard Header */}
			<div className="dashboard-header">
				<h1>DASHBOARD</h1>
			</div>

			<div className="center-container">
				<div className="dashboard-button-group">
					<button className="play-button" onClick={props.playGame}>PLAY</button>
					<button className="go-back-button" onClick={props.onBackButtonClick}>Go Back</button>
				</div>

				<div className="profile-button-container">
					<img
					src={ProfileButton}
					alt="Profile"
					onClick={toggleProfileCard}
					className="profile-button"
					/>
				</div>
			</div>

			{/* Chess Pieces */}
			<div className="chess-pieces">
				<img
				src={BlackKing}
				alt="Black King"
				className="black-king-statue"
				/>
				<img
				src={WhiteKing}
				alt="White King"
				className="white-king-statue"
				/>
				<img
				src={BlackQueen}
				alt="Black Queen"
				className="black-queen-statue"
				/>
				<img
				src={WhiteQueen}
				alt="White Queen"
				className="white-queen-statue"
				/>
			</div>

			{/* Profile Card */}
			{showProfileCard && (
				<div className="profile-card">
				<h3>Profile Name</h3>
				<div className="history-section">
					<p>History section</p>
				</div>
				</div>
			)}
		</div>
    );
}
