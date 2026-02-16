package ua.opnu;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StudentConsumerDemo {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Іван", "АІ-243", new int[]{90, 85, 88}),
                new Student("Марія", "АІ-243", new int[]{45, 70, 55}),
                new Student("Петро", "АІ-243", new int[]{30, 40, 25}),
                new Student("Олена", "АІ-243", new int[]{95, 92, 98}),
                new Student("Андрій", "АІ-243", new int[]{60, 75, 80}),
                new Student("Катерина", "АІ-243", new int[]{50, 65, 70})
        );

        Consumer<Student> printConsumer = student ->
                System.out.println(student.getGroup() + " " + student.getName());

        System.out.println("Список студентів (група + ім'я):");
        students.forEach(printConsumer);

        System.out.println("\nТой самий список, але через пряму лямбду:");
        students.forEach(student ->
                System.out.println("• " + student.getGroup() + " — " + student.getName())
        );
    }
}