package HW.testcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CountWordsTest extends UtilsTest {
    /**
     * Пустую строку
     * null
     * Строку с несколькими пробелами
     * кейсы:
     * "Hello World" -> 2
     * "  Java is awesome " -> 3
     * "", "  " -0
     * null -> IllegalArgumentException
     * ё
     */

    @Test
    public void countWordsNormalString() {
        String input = "Hello World";
        assertEquals(2, utils.countWords(input));
    }

    @Test
    public void countWordsNormalStringWithExtraSpace() {
        String input = " Java is awesome ";
        assertEquals(3, utils.countWords(input));
    }

    @ParameterizedTest
    @CsvSource({
            "'', 0",
            "'  ', 0"
    })
    public void countWordsTest(String sentence, int expected) {
        assertEquals(expected, utils.countWords(sentence));
    }

    @Test
    public void countWordsNull() {
        assertThrows(IllegalArgumentException.class, () -> utils.countWords(null));
    }
}
