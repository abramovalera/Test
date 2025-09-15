package HW.testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindSecondMaxTest extends UtilsTest {
    /**
     * Обычные массивы
     * Массив с одинаковыми числами
     * Один элемент в массиве (должно выбрасываться исключение)
     * кейсы:
     * [1,8,3,9,2] -> 8
     * [5,5,5,5] -> NoSuchElementException
     * [8] -> NoSuchElementException
     * [] -> NoSuchElementException
     */

    @DisplayName("Поиск второго максимального числа")
    @Test
    public void FindSecondMaxArray() {
        int[] numbers = {1, 8, 3, 9, 2};
        int expected = 8;
        assertEquals(expected, utils.findSecondMax(numbers));
    }

    @DisplayName("NoSuchElementException")
    @ParameterizedTest
    @MethodSource("invalidArrays")
    public void FindSecondMaxIllegalArgumentException(int[] numbers) {
        assertThrows(NoSuchElementException.class, () -> utils.findSecondMax(numbers));
    }

    static Stream<int[]> invalidArrays() {
        return Stream.of(
                new int[]{5, 5, 5, 5}
        );
    }

    @DisplayName("IllegalArgumentException")
    @ParameterizedTest
    @MethodSource("invalidArrays2")
    public void FindSecondMaxNoSuchElementException(int[] numbers) {
        assertThrows(IllegalArgumentException.class, () -> utils.findSecondMax(numbers));
    }

    static Stream<int[]> invalidArrays2() {
        return Stream.of(
                new int[]{8},
                new int[]{}
        );
    }
}
