package HW.testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountVowelsTest extends UtilsTest {
    /**
     * Разные строки ("hello", "java", "AEIOU", "")
     * null (должно выбрасываться исключение)
     * Строки без гласных
     * кейсы:
     * "hello" -> 2
     * "java" - > 2
     * "AEIOU" -> 5
     * "thgh" -> 0
     * null -> IllegalArgumentException
     * corner case:
     * "" -> 0
     */


    static Stream<Arguments> StringForVowels() {
        return Stream.of(
                Arguments.of("hello", 2),
                Arguments.of("java", 2),
                Arguments.of("AEIOU", 5),
                Arguments.of("thgh", 0),
                Arguments.of("", 0)

        );
    }
    @DisplayName("Проверка количество гласных")
    @ParameterizedTest
    @MethodSource("StringForVowels")
    public void countVowelsShouldReturnCorrectCountString(String input, int expected) {
        int result = utils.countVowels(input);
        assertEquals(expected, result);
    }

    @DisplayName("Проверка IllegalArgumentException")
    @Test
    public void countVowelsShouldThrowsWhenNull(){
        assertThrows(IllegalArgumentException.class, () -> utils.countVowels(null));
    }
}
