package practice_1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("class StringProcessor, method reverse")
public class ReverseStringTest extends StringProcessorTest{
    /**
     * Тесты для переворота строки:
     * heppy path: "saha" -> "ahsas
     * corner cases:
     * "" -> ""
     * "a" -> "a"
     * null -> IllegalArgument Exception
     */

    public static Stream<Arguments> validStringToReverse () {
        return Stream.of(
                //happy path: "sasha" -> "ahsas
                Arguments.of("sasha", "ahsas"),
                // corner case: "" -> ""
                Arguments.of("", ""),
                // corner case: "a" -> "a"
                Arguments.of("a", "a"));
    }

    @ParameterizedTest
    @MethodSource("validStringToReverse")
    public void userCanReverseValidString(String initialString, String expectedString) {
        String reversedString = stringProcessor.reverse(initialString);

        assertEquals(expectedString,
                reversedString, "String reversed incorrectly!");
    }

    @Test
    public void userCannotReverseNullString() {

        assertThrows(IllegalArgumentException.class, () -> {
            stringProcessor.reverse(null);
        }, "Reversing of null string shuild lead to IllegalArgumentException");
    }
}
