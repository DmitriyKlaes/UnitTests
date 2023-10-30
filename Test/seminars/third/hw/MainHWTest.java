package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MainHWTest {
    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 6, 8})
    void testEvenOddNumberPositive(int input) {
        assertTrue(mainHW.evenOddNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 9, 11})
    void testEvenOddNumberNegative(int input) {
        assertFalse(mainHW.evenOddNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 50, 99})
    void testisInIntervalPositive(int input) {
        assertTrue(mainHW.isInInterval(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100, 0})
    void testisInIntervalNegative(int input) {
        assertFalse(mainHW.isInInterval(input));
    }
}
