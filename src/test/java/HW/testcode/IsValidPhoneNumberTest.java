package HW.testcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class IsValidPhoneNumberTest extends UtilsTest {
    /**
     * Корректные номера ("+1 1234567890")
     * Некорректные номера ("12345", "invalid")
     * <p>
     * кейсы:
     * "+1 1234567890" → true.
     * "+44 9876543210" → true.
     * "+999 1111111111" → true.
     * "12345" → false.
     * "invalid" → false.
     * "+1 abcdefghij" → false.
     * "+1234 1234567890" (слишком длинный код страны) → false.
     * "+1 123" (недостаточно цифр) → false.
     * "" (пустая строка) → false.
     * null → IllegalArgumentException.
     */


    @ParameterizedTest
    @ValueSource(strings = {
            "12345",
            "invalid",
            "+1 abcdefghij",
            "+1234 1234567890",
            "+1 123",
            ""
    })
    public void invalidPhoneNumber(String phone) {
        assertFalse(utils.isValidPhoneNumber(phone));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "+1 1234567890",
            "+44 9876543210",
            "+999 1111111111"
    })
    public void validPhoneNumber(String phone) {
        assertTrue(utils.isValidPhoneNumber(phone));
    }

    @Test
    public void nullPhoneNumber() {
        assertThrows(NullPointerException.class, () -> utils.isValidPhoneNumber(null));
    }
}
