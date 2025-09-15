package HW.testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest extends UtilsTest {
    /**
     * 0! = 1
     * Маленькие числа (1!, 5!, 7!)
     * Отрицательные числа (должно выбрасываться исключение)
     * кейсы:
     * 0! -> 1
     * 1 -> 1, 5 -> 120, 7 -> 5040
     * -1 -> IllegalArgumentException
     */

    @DisplayName("Нулевой факториал")
    @Test
    public void factorialZero() {
        assertEquals(1, utils.factorial(0));
    }

    @DisplayName("Положительный факториал")
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "5, 120",
            "7, 5040"
    })
    public void factorialPositive(int n, int expected) {
        assertEquals(expected, utils.factorial(n));
    }

    @DisplayName("Отрицательный факториал")
    @Test
    public void factorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> utils.factorial(-1));
    }
}
