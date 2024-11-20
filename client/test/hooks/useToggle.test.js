import { renderHook, act } from '@testing-library/react-hooks';
import { useToggle } from '../../src/hooks/useToggle';

describe('useToggle', () => {
    test('Johnh9 test: should initialize with the starting value', () => {
        const { result } = renderHook(() => useToggle(true));
        expect(result.current[0]).toBe(true);
    });

    test('Johnh9 test: should toggle the value', () => {
        const { result } = renderHook(() => useToggle(false));

        // Initial state should be false
        expect(result.current[0]).toBe(false);

        act(() => {
            result.current[1]();
        });

        // Should now be true
        expect(result.current[0]).toBe(true);

        act(() => {
            result.current[1]();
        });

        // Should now be false
        expect(result.current[0]).toBe(false);
    });

    test('Johnh9 test: should handle initial false value', () => {
        const { result } = renderHook(() => useToggle(false));
        expect(result.current[0]).toBe(false);
    });

    test('Johnh9 test: should handle initial true value', () => {
        const { result } = renderHook(() => useToggle(true));
        expect(result.current[0]).toBe(true);
    });
});