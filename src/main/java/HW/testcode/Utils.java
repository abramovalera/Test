package HW.testcode;

import java.util.Arrays;

public class Utils {

    //Проверка чётности числа
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    //Подсчёт количества гласных в строке
    public int countVowels(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return (int) input.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
    }

    // Разворот строки
    public String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    //Поиск максимального числа в массиве
    public int findMax(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }

    //Проверка, является ли год високосным
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    //Проверка валидности email
    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }

    //Факториал числа
    public int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    // Поиск второго максимального числа в массиве
    public int findSecondMax(int[] numbers) {
        return Arrays.stream(numbers).distinct().sorted().skip(numbers.length - 2).findFirst().orElseThrow();
    }

    //Подсчёт количества слов в строке
    //изменил метод для корректной работы
    public int countWords(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        String trimmed = sentence.trim(); // убираем пробелы в начале и конце
        if (trimmed.isEmpty()) {
            return 0;
        }

        return trimmed.split("\\s+").length; // делим по одному или нескольким пробелам
    }

    // Проверка валидности номера телефона
    public boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\+\\d{1,3} \\d{10}");
    }


}
