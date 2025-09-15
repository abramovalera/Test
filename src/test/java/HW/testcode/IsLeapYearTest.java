package HW.testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsLeapYearTest extends UtilsTest {

    /**
     * Обычные годы
     * Високосные (2020, 2000, 1600)
     * Года, которые делятся на 100, но не на 400 (1900, 2100)
     * кейсы:
     * обычные года:
     * 2019, 2021 -> false
     * високосные:
     * 2020, 2000, 1600 -> true
     * делящиеся на 100, но не на 400:
     * 1900, 2100 -> false
     * граничные случаи:
     * 0, 4, 400 -> true
     */
    @DisplayName("Проверка корректного определения високосного года")
    @ParameterizedTest
    @MethodSource("years")
    public void shouldReturnCorrectLeapYearStatus(int year, boolean expected) {
        assertEquals(expected, utils.isLeapYear(year));
    }

    static Stream<Arguments> years() {
        return Stream.of(
                //обычные года
                Arguments.of(2019, false),
                Arguments.of(2021, false),
                //високосные
                Arguments.of(2020, true),
                Arguments.of(2000, true),
                Arguments.of(1600, true),
                //делящиеся на 100, но не на 400
                Arguments.of(1900, false),
                Arguments.of(2100, false),
                //граничные случаи
                Arguments.of(0, true),
                Arguments.of(4, true),
                Arguments.of(400, true)
        );
    }
}
