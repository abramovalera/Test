package practice_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class IsPalindromeTest extends StringProcessorTest{


    /**
     * Тесты для проверки, является ли палиндромом:
     * позитивные кейсы:
     * - четное кол-во: "abba" -> true
     * - нечетное кол-во: "hah" -> true
     * негативные кейсы:
     * - "john" -> false
     * corner cases:
     * - "a" -> true
     * - "" -> true
     * - null -> IllegalArgumentException
     */

    @ParameterizedTest
    @ValueSource(strings = {
            // позитивные сценарии
            "abba", "hah",
            // угловые кейсы
            "a", ""})
    public void userCanCheckIfValidStringIsPalindrome(String initialString) {
        boolean actualResult = stringProcessor.isPalindrome(initialString);

        assertTrue(actualResult);

    }

    @Test
    public void userCanCheckIfValidStringIsNotPalindrome() {
        String initialString = "john";

        boolean actualResult = stringProcessor.isPalindrome(initialString);

        assertFalse(actualResult);
    }

    @Test
    public void userCannotCheckIfNullStringPalindrome() {

        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessor.reverse(null);
        }, "Checking if Null string is palindrome should lead to IllegalArgumentException");
    }
}
