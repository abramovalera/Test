package HW.testcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsEvenTest extends UtilsTest{

    /**
     * Чётные и нечётные числа
     * Нулевое значение
     * Отрицательные числа
     * кейсы:
     * 1, -1
     * 2, -2, 0
     */
    @DisplayName("Проверка четное число")
    @ParameterizedTest
    @ValueSource(ints = {2, -2, 0})
    public void isEvenShouldReturnTrueWhenNumbersIsEven(int number) {
        assertTrue(utils.isEven(number));
    }

    @DisplayName("Проверка не четное число")
    @ParameterizedTest
    @ValueSource(ints = {1, -1})
    public void isEvenShouldReturnFalseWhenNumbersIsNoEven(int number) {
        assertFalse(utils.isEven(number));
    }
}
