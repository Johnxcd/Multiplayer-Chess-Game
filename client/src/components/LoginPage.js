import React, { useEffect, useState } from 'react';
import { useServerSettings } from '../hooks/useServerSettings';
import TeamPicture from '../../../images/MonkeyCS.jpg';
import '../static/styles/student-styles.scss'

export default function LoginPage(props) {
	const [serverSettings, processServerConfigSuccess] = useServerSettings(props.showMessage);

	const loginAttempt = () => {
		//TODO: Make it so that this tried to log in player and confirm stuff with database
		console.log("Attempted a log in from a user");
	}

	return (
		<div className='page'>
			<h1>Please Login</h1>
			<button onClick={loginAttempt}> Login </button>
		</div>
	);
}


