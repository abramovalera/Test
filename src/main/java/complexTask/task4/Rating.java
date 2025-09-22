package complexTask.task4;

public class Rating<T extends Number> {

    private final T value;

    public Rating(T value) {
        if (value.doubleValue() < 1 || value.doubleValue() > 10) {
            throw new IllegalArgumentException("Рейтинг может быть от 1 до 10");
        }
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public double doubleValue() {
        return value.doubleValue();

    }
}
