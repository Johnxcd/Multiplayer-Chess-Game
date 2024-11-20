import React, { useState } from 'react';
import { SnackbarProvider, useSnackbar } from 'notistack';
import HomePage from './HomePage';
import LoginPage from './LoginPage';
import GamePage from './GamePage';
import DashboardPage from './DashboardPage';

export default function App() {
    return (
        <SnackbarProvider maxSnack={3} preventDuplicate>
            <HookCaller />
        </SnackbarProvider>
    );
}

export const HookCaller = () => {
    const { enqueueSnackbar } = useSnackbar();
    const [currentPage, setCurrentPage] = useState('home');

    function showMessage(message, variant = "info") {
        enqueueSnackbar(message, { variant: variant })
    }

    const goToLoginPage = () => {
        setCurrentPage('login')
    };

    const goToHomePage = () => {
        setCurrentPage('home')
    };

    const goToDashboardPage = () => {
        setCurrentPage('dashboard')
    }

    const goToGamePage = () => {
        setCurrentPage('game')
    }

    let pageComponent;
    switch (currentPage) {
        case 'game':
            pageComponent = <GamePage 
            showMessage={showMessage}
            onBackButtonClick={goToDashboardPage}
            />;
            break;
        case 'login':
            pageComponent = <LoginPage 
            showMessage={showMessage} 
            onBackButtonClick={goToHomePage} 
            onLoginSuccess={goToDashboardPage} // Navigate to dashboard on successful login
            />;
            break;
        case 'dashboard':
            pageComponent = <DashboardPage 
            showMessage={showMessage} 
            onBackButtonClick={goToHomePage} 
            playGame={goToGamePage}
            />;
            break;
        default:
            pageComponent = <HomePage showMessage={showMessage} onLoginClick={goToLoginPage} />;
            break;
    }

    return pageComponent;


    return (
    currentPage === 'home' ?
    <HomePage showMessage={showMessage} onLoginClick={goToLoginPage}/>
    :
    <LoginPage showMessage={showMessage} onBackButtonClick={goToHomePage}/>
    );
};
