package HW.testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindMaxTest extends UtilsTest {
    /**
     * Обычный массив ([3, 5, 7, 2])
     * Один элемент в массиве
     * Отрицательные числа
     * Пустой массив (должно выбрасываться исключение)
     * кейсы:
     * [3, 5, 7, 2] -> 7
     * [36] -> 36
     * [-1, -8, -56] -> -1
     * [] -> исключение
     */

    @DisplayName("Поиск максимального положительного числа в массиве")
    @Test
    public void findMaxShouldReturnMaxPositiveNumber() {
        int[] numbers = {3, 5, 7, 2};
        int result = utils.findMax(numbers);
        assertEquals(7, result);
    }

    @DisplayName("Поиск максимального отрицательного числа в массиве")
    @Test
    public void findMaxShouldReturnMaxNegativeNumber() {
        int[] numbers = {-1, -8, -56};
        int result = utils.findMax(numbers);
        assertEquals(-1, result);
    }

    @DisplayName("Поиск максимального отрицательного числа в массиве из 1 числа")
    @Test
    public void shouldReturnSingleElementWhenArrayHasOneElement() {
        int[] numbers = {36};
        int result = utils.findMax(numbers);
        assertEquals(36, result);
    }

    @DisplayName("Проверка исключения пустой массив")
    @Test
    public void findMaxShouldReturnException() {
        int [] numbers = {};
        assertThrows(NoSuchElementException.class, () -> utils.findMax(numbers));
    }


}
