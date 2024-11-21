import React from 'react';
import { renderHook, act } from '@testing-library/react-hooks';
import { useServerSettings } from '../../src/hooks/useServerSettings';
import * as restfulAPI from '../../src/utils/restfulAPI';
import * as constants from '../../src/utils/constants';

jest.mock('../../src/utils/restfulAPI');
jest.mock('../../src/utils/constants');

describe('useServerSettings', () => {
    afterEach(() => {
        jest.clearAllMocks();
    });

    test('Johnh9 test: should initialize with the original server URL', () => {
        jest.spyOn(restfulAPI, 'getOriginalServerUrl').mockReturnValue('http://localhost:43125');
        const { result } = renderHook(() => useServerSettings(jest.fn()));
        expect(result.current[0].serverUrl).toBe('http://localhost:43125');
    });

    test('Johnh9 test: should fetch and process the server config successfully', async () => {
        const mockServerConfig = { endpoint: 'http://localhost:43125/api' };
        jest.spyOn(restfulAPI, 'sendAPIRequest').mockResolvedValue(mockServerConfig);
        jest.spyOn(constants.LOG, 'info').mockImplementation(() => {});

        const { result, waitForNextUpdate } = renderHook(() => useServerSettings(jest.fn()));
        await waitForNextUpdate();

        expect(result.current[0].serverConfig).toEqual(mockServerConfig);
        expect(result.current[0].serverUrl).toBe('http://localhost:43125');
        expect(constants.LOG.info).toHaveBeenCalledWith('Switching to Server:', 'http://localhost:43125');
    });

    test('Johnh9 test: should handle a failed config request', async () => {
        jest.spyOn(restfulAPI, 'sendAPIRequest').mockResolvedValue(null);
        const mockShowMessage = jest.fn();

        const { result } = renderHook(() => useServerSettings(mockShowMessage));

        await act(async () => {
            // Wait for the effect to complete
            await new Promise((resolve) => setTimeout(resolve, 1000));
        });

        expect(result.current[0].serverConfig).toBeNull();
        expect(mockShowMessage).toHaveBeenCalledWith(
            'Config request to http://localhost:43125 failed. Check the log for more details.',
            'error'
        );
    });
});