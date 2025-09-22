package complexTask.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    public UserValidator validator = new UserValidator();


    /**
     * Проверка имени (исключение):
     * пустое, с пробелом, с маленькой, заглавная не в начале,
     */

    @ParameterizedTest
    @ValueSource(strings = {
            "", " Valery", "valery", "vAlery"
    })

    public void TestValidatorNameException(String name) {
        assertThrows(InvalidUserException.class, () -> validator.checkName(name));
    }

    /**
     * Проверка имени (null)
     */
    @Test
    public void TestNameNullException() {
        assertThrows(InvalidUserException.class, () -> validator.checkName(null));
    }

    @Test
    public void TestName() {
        validator.checkName("Valery");
    }

    /**
     * Проверка возраста(исключение):
     */

    @ParameterizedTest
    @ValueSource(ints = {
            17, 101, -1
    })
    public void TestValidatorAgeException(int age) {
        assertThrows(InvalidUserException.class, () -> validator.checkAge(age));
    }

    /**
     * Проверка возраста:
     */

    @ParameterizedTest
    @ValueSource(ints = {
            18, 50, 100
    })
    public void TestAge(int age) {
        assertDoesNotThrow(() -> validator.checkAge(age));
    }

    /**
     * Проверка email(исключения)
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "", "test.mail.ru", "@mail.ru", "test.ru", " test@mail.ru"
    })
    public void TestValidatorEmailException(String email) {
        assertThrows(InvalidUserException.class, () -> validator.checkEmail(email));
    }

    /**
     * Проверка email (null)
     */
    @Test
    public void TestEmailNull() {
        assertThrows(InvalidUserException.class, () -> validator.checkEmail(null));
    }

    @Test
    public void TestEmail() {
        assertDoesNotThrow(() -> validator.checkEmail("test@mail.ru"));
    }

    @Test
    public void TestValidationOn() {
        validator.setValidationEnabled(true);
        User userOn = new User("valery", 15, "test");
        assertThrows(InvalidUserException.class, () -> validator.validation(userOn));
    }

    @Test
    public void TestValidationOff() {
        validator.setValidationEnabled(false);
        User userOff = new User("valery", 15, "test");
        assertDoesNotThrow(() -> validator.validation(userOff));
    }
}
