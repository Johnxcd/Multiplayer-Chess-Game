import React from 'react';
import { renderHook, act } from '@testing-library/react-hooks';
import { useServerInputValidation } from '../../src/hooks/useServerInputValidation';
import * as restfulAPI from '../../src/utils/restfulAPI';

jest.mock('../../src/utils/restfulAPI');

describe('useServerInputValidation', () => {
    afterEach(() => {
        jest.clearAllMocks();
    });

    test('Johnh9 test: should initialize with the provided server URL', () => {
        const mockServerUrl = 'http://localhost:43125';
        const mockClose = jest.fn();
        const { result } = renderHook(() => useServerInputValidation(mockServerUrl, mockClose));

        expect(result.current[0]).toBe(mockServerUrl);
    });

    test('Johnh9 test: should update server input and attempt config request with valid URL', async () => {
        const mockServerUrl = 'http://localhost:43125';
        const mockClose = jest.fn();
        const mockConfig = { endpoint: 'http://localhost:43125/api' };
        jest.spyOn(restfulAPI, 'sendAPIRequest').mockResolvedValue(mockConfig);

        const { result } = renderHook(() => useServerInputValidation(mockServerUrl, mockClose));

        await act(async () => {
            result.current[1]('http://localhost:43125');
        });

        expect(result.current[0]).toBe('http://localhost:43125');
        expect(result.current[2]).toEqual(mockConfig);
        expect(result.current[3]).toBe(true);
    });

    test('Johnh9 test: should not attempt config request with invalid URL', async () => {
        const mockServerUrl = 'http://localhost:43125';
        const mockClose = jest.fn();
        const { result } = renderHook(() => useServerInputValidation(mockServerUrl, mockClose));
    
        await act(async () => {
            result.current[1]('invalid-url');
        });
    
        expect(result.current[0]).toBe('invalid-url');
        expect(result.current[2]).toBeNull();
        expect(result.current[3]).toBe(false);
    });

    test('Johnh9 test: should reset modal with the original server URL', async () => {
        const mockServerUrl = 'http://localhost:43125';
        const mockClose = jest.fn();
        const { result } = renderHook(() => useServerInputValidation(mockServerUrl, mockClose));
    
        await act(async () => {
            result.current[4](mockServerUrl);
        });
    
        expect(result.current[0]).toBe(mockServerUrl);
        expect(result.current[3]).toBe(true);
        expect(mockClose).toHaveBeenCalled();
    });
});