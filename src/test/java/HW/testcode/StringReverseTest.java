package HW.testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringReverseTest extends UtilsTest {
    /**
     * Обычные строки
     * Пустую строку
     * null (должно возвращаться null)
     * кейсы:
     * "abc" -> "cba"
     * "123" -> "321"
     * "ABB" -> "BBA"
     * "" -> ""
     * "null" -> "null"
     */

@DisplayName("Проверка разворота строки")
    @ParameterizedTest
    @CsvSource({
            "abc, cba",
            "ABB, BBA",
            "123, 321",
            "a, a",
            "'',''"
    })
    public void reverseShouldReturnReversedString(String input, String expected) {
        assertEquals(expected, utils.reverse(input));
    }

    @DisplayName("Проверка null")
    @Test
    public void reverseShouldReturnNull() {
        assertNull(utils.reverse(null));
    }
}
