package ua.opnu;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class PowerOfTwoFunction {

    public static void main(String[] args) {
        Function<Integer, Integer> powerOfTwo = n -> (int) Math.pow(2, n);

        List<Integer> exponents = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("n → 2^n");
        System.out.println("--------------");

        for (Integer n : exponents) {
            int result = powerOfTwo.apply(n);
            System.out.println(n + " → " + result);
        }

        System.out.println("\nРезультат через map (стилістично):");
        exponents.stream()
                .map(n -> "2^" + n + " = " + powerOfTwo.apply(n))
                .forEach(System.out::println);
    }
}