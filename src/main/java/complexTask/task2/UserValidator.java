package complexTask.task2;


public class UserValidator {

    private boolean validationEnabled = true;

    public void setValidationEnabled(boolean enabled) {
        this.validationEnabled = enabled;
    }

    public void checkName(String name) {
        if (name == null || name.isBlank()) //проверка на null и пустую строку
        {
            throw new InvalidUserException("Имя не может быть пустое");
        }
        if (!Character.isUpperCase(name.charAt(0))) {
            throw new InvalidUserException("Имя должно быть с заглавной буквы");
        }
    }

    public void checkAge(int age) {
        if (age < 18 || age > 100) {
            throw new InvalidUserException("Возраст должен быть (18 - 100)");
        }
    }

    public void checkEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new InvalidUserException("Email не должен быть пустым");
        }
        String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$"; // регулярное выражение
        if (!email.matches(emailRegex)) // проверяет, соответствует ли строка заданному регулярному выражению (Regex).
        {
            throw new InvalidUserException("Email некорректный");
        }
    }

    public void validation(User user) {
        if (!validationEnabled) return;

        checkName(user.getName());
        checkAge(user.getAge());
        checkEmail(user.getEmail());
    }
}
