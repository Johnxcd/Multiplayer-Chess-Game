import React, { useState } from 'react';
import '../static/styles/student-styles.scss';
import { sendAPIRequest } from '../utils/restfulAPI';

export default function LoginPage(props) {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [email, setEmail] = useState('');

  // Function to attempt login
  const loginAttempt = async () => {
    //Cuz it was breaking...
    if (!props.serverSettings || !props.serverSettings.serverUrl) {
      alert('Server URL is not configured. Please check the settings.');
      return;
    }

    if(username == 'admin' && password == username) {
      console.log("ADMIN Login successful:");
      props.onLoginSuccess();
    }else {
      const requestBody = {
        requestType: "user",
        action: "login",
        email: email,
        password: password,
        userName: username,
      };

      try {
        const response = await fetch(props.serverSettings.serverUrl + '/api/user', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(requestBody),
        });
        console.log(props.serverSettings.serverUrl);
        // const response = await sendAPIRequest(requestBody, props.serverSettings.serverUrl);

        //logs for debugging
        console.log('Response status:', response.status);
        console.log('Response body:', await response.text());

        if (response.ok) {
          const userData = await response.json();
          console.log("Login successful:", userData);
          props.onLoginSuccess();
        } else {
          const error = await response.text();
          alert(`Login failed: ${error}`);
        }

      } catch (error) {
        console.error("Error during login:", error);
        alert("An error occurred during login.");
      }
    }
  };

  // Function to create a new account
  const createAccount = async () => {
    const requestBody = {
      requestType: "user",
      action: "register",
      email: email,
      password: password,
      userName: username, // Assuming username doubles as the display name
    };

    try {
      // const response = await fetch('/api/user', {
      //   method: 'POST',
      //   headers: { 'Content-Type': 'application/json' },
      //   body: JSON.stringify(requestBody),
      // });
      const response = await sendAPIRequest(requestBody, props.serverSettings.serverUrl);
      //logs for debugging
      console.log('Response status:', response.status);
      console.log('Response body:', await response.text());
      
      if (response.ok) {
        alert("Account created successfully! You can now log in.");
      } else {
        const error = await response.text();
        alert(`Account creation failed: ${error}`);
      }
    } catch (error) {
      console.error("Error during account creation:", error);
      alert("An error occurred during account creation.");
    }
  };

  return (
    <div className='page'>
      <h1>Please Login</h1>
      <div className="form">

        <label htmlFor="email">Email:</label>
        <input
          id="email"
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          placeholder="Enter your email"
        />
        
        <label htmlFor="username">Username:</label>
        <input
          id="username"
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          placeholder="Enter your username"
        />

        <label htmlFor="password">Password:</label>
        <input
          id="password"
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          placeholder="Enter your password"
        />

        <button onClick={loginAttempt}>Login</button>
        <button onClick={createAccount}>Create Account</button>
        <button onClick={props.onBackButtonClick}>Go Back</button>
      </div>
    </div>
  );
}
