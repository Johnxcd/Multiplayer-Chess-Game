import React from 'react';
import ReactDOM from 'react-dom';
import App from '../src/components/App';

jest.mock('react-dom', () => ({ render: jest.fn() }));

describe('entry.js', () => {
    test('Johnh9 test: should render App component', () => {
        require('../src/entry');
        expect(ReactDOM.render).toHaveBeenCalledWith(<App />, document.getElementById('root'));
    });
});