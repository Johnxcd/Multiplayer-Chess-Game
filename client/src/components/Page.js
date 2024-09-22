import React, { useEffect, useState } from 'react';
import { useServerSettings } from '../hooks/useServerSettings'

export default function Page(props) {
	const [serverSettings, processServerConfigSuccess] = useServerSettings(props.showMessage);

	return (
		<h1>{serverSettings.serverUrl}</h1>
	);
}


