package ua.opnu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentFilter {

    public static List<Student> filterStudents(Student[] students, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (predicate.test(student)) {
                result.add(student);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Іван", "AI-243", new int[]{90, 85, 88}),
                new Student("Марія", "AI-243", new int[]{45, 70, 55}),
                new Student("Петро", "AI-243", new int[]{30, 40, 25}),
                new Student("Олена", "AI-243", new int[]{95, 92, 98}),
                new Student("Андрій", "AI-243", new int[]{60, 75, 80}),
                new Student("Катерина", "AI-243", new int[]{50, 65, 70})
        };

        Predicate<Student> noDebtPredicate = student -> !student.hasDebt();

        List<Student> goodStudents = filterStudents(students, noDebtPredicate);

        System.out.println("Студенти без заборгованостей:");
        goodStudents.forEach(System.out::println);
    }
}