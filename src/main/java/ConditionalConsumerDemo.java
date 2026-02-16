package ua.opnu;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConditionalConsumerDemo {

    public static <T> void processIf(List<T> list,
                                     Predicate<T> predicate,
                                     Consumer<T> consumer) {
        for (T item : list) {
            if (predicate.test(item)) {
                consumer.accept(item);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                12, 15, 17, 20, 21, 24, 27, 30);

        System.out.println("Парні числа:");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Consumer<Integer> printNumber = n -> System.out.print(n + " ");

        processIf(numbers, isEven, printNumber);

        System.out.println("\n\nЧисла, кратні 3:");
        processIf(numbers,
                n -> n % 3 == 0,
                n -> System.out.print(n + " "));

        System.out.println("\n\nПрості числа:");
        Predicate<Integer> isPrime = n -> {
            if (n <= 1) return false;
            if (n == 2) return true;
            if (n % 2 == 0) return false;
            for (int i = 3; i <= Math.sqrt(n); i += 2) {
                if (n % i == 0) return false;
            }
            return true;
        };

        Consumer<Integer> printWithStars = n -> System.out.print("★" + n + " ");
        processIf(numbers, isPrime, printWithStars);
        System.out.println("\n\nЧисла більше 15:");
        processIf(numbers,
                n -> n > 15,
                n -> System.out.print("[" + n + "] "));

        System.out.println();
    }
}