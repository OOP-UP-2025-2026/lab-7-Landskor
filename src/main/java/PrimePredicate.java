package ua.opnu;

import java.util.function.Predicate;

public class PrimePredicate {
    public static void main(String[] args) {

        // Лямбда-вираз: перевірка на просте число
        Predicate<Integer> isPrime = n -> {
            if (n <= 1) return false;
            if (n == 2) return true;
            if (n % 2 == 0) return false;
            for (int i = 3; i <= Math.sqrt(n); i += 2) {
                if (n % i == 0) return false;
            }
            return true;
        };

        // Тестування
        System.out.println("2 просте? " + isPrime.test(2));
        System.out.println("3 просте? " + isPrime.test(3));
        System.out.println("4 просте? " + isPrime.test(4));
        System.out.println("17 просте? " + isPrime.test(17));
        System.out.println("25 просте? " + isPrime.test(25));
        System.out.println("29 просте? " + isPrime.test(29));
    }
}