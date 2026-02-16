package ua.opnu;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class NumberToStringFunction {

    public static List<String> stringify(Integer[] numbers, Function<Integer, String> converter) {
        return Arrays.stream(numbers)
                .map(converter)
                .toList();
    }

    public static void main(String[] args) {
        Function<Integer, String> digitToWord = n -> {
            return switch (n) {
                case 0 -> "нуль";
                case 1 -> "один";
                case 2 -> "два";
                case 3 -> "три";
                case 4 -> "чотири";
                case 5 -> "п'ять";
                case 6 -> "шість";
                case 7 -> "сім";
                case 8 -> "вісім";
                case 9 -> "дев'ять";
                default -> "?";
            };
        };

        Integer[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<String> words = stringify(numbers, digitToWord);

        System.out.println("Цифра → Слово");
        System.out.println("----------------");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " → " + words.get(i));
        }
        System.out.println("\nВесь список слів:");
        System.out.println(words);
    }
}