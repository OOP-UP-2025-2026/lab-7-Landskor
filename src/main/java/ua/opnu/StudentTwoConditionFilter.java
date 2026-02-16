package ua.opnu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentTwoConditionFilter {

    public static List<Student> filterByTwoConditions(Student[] students,
                                                      Predicate<Student> condition1,
                                                      Predicate<Student> condition2) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (condition1.test(student) && condition2.test(student)) {
                result.add(student);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Іван", "АІ-243", new int[]{90, 85, 88}),
                new Student("Марія", "АІ-243", new int[]{45, 70, 55}),
                new Student("Петро", "АІ-243", new int[]{30, 40, 25}),
                new Student("Олена", "АІ-243", new int[]{95, 92, 98}),
                new Student("Андрій", "АІ-243", new int[]{60, 75, 80}),
                new Student("Катерина", "АІ-243", new int[]{50, 65, 70})
        };

        Predicate<Student> noDebt = student -> {
            for (int mark : student.getMarks()) {
                if (mark < 60) return false;
            }
            return true;
        };

        Predicate<Student> groupFilter = student -> student.getGroup().equals("АІ-243");

        List<Student> result = filterByTwoConditions(students, noDebt, groupFilter);

        System.out.println("Студенти групи АІ-243 без заборгованостей:");
        if (result.isEmpty()) {
            System.out.println("Таких студентів немає");
        } else {
            result.forEach(System.out::println);
        }
    }
}