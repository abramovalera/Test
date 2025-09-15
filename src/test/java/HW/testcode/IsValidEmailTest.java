package HW.testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsValidEmailTest extends UtilsTest {
    /**
     * Корректные и некорректные email ("test@example.com", "bad@.com", "no-at-symbol")
     * null
     * кейсы:
     * test@example.com -> true
     * "bad@.com", "no-at-symbol" -> false
     */

    @DisplayName("Валидный email")
    @ParameterizedTest
    @ValueSource(strings = {
            "test@example.com", "user.name@domain.co", "a@b.cc"
    })
    public void validEmail(String email) {
        assertTrue(utils.isValidEmail(email));
    }


    @DisplayName("Не валидный email")
    @ParameterizedTest
    @ValueSource(strings = {
            "bad@.com", "no-at-symbol", ""
    })
    public void NoValidEmail(String email) {
        assertFalse(utils.isValidEmail(email));
    }

    @DisplayName("Null")
    @Test
    public void ValidEmailNull() {
        assertFalse(utils.isValidEmail(null));
    }
}



