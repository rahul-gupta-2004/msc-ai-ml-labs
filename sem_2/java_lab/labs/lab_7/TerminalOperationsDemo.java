package sem_2.java_lab.labs.lab_7;

import java.util.*;
import java.util.stream.*;

class StudentStream {
    String name;
    int marks;

    StudentStream(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + "(" + marks + ")";
    }
}

public class TerminalOperationsDemo {
    public static void main(String[] args) {

        // Integer list
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 25, 35);

        System.out.println("=== Terminal Operations on Integers ===\n");

        // 1. forEach() - prints each element
        System.out.println("1. forEach() - prints each element:");
        numbers.stream()
                .filter(n -> n > 25)
                .map(n -> n * 2)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 2. count() - returns number of elements
        System.out.println("2. count() - counts elements after filter:");
        long count = numbers.stream()
                .filter(n -> n > 25)
                .count();
        System.out.println("Count of numbers > 25: " + count);
        System.out.println();

        // 3. collect() - gathers results into a collection
        System.out.println("3. collect() - gathers into a list:");
        List<Integer> collectedList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n + 5)
                .collect(Collectors.toList());
        System.out.println("Even numbers +5: " + collectedList);
        System.out.println();

        // 4. reduce() - combines elements into single result
        System.out.println("4. reduce() - combines all elements:");
        Optional<Integer> sum = numbers.stream()
                .filter(n -> n > 20)
                .reduce((a, b) -> a + b);
        System.out.println("Sum of numbers > 20: " + sum.get());
        System.out.println();

        // Student list
        List<StudentStream> students = Arrays.asList(
                new StudentStream("Alice", 85),
                new StudentStream("Bob", 60),
                new StudentStream("John", 90),
                new StudentStream("Emma", 55));

        System.out.println("=== Terminal Operations on Students ===\n");

        // forEach on students
        System.out.println("1. forEach() - students with marks >= 60:");
        students.stream()
                .filter(s -> s.marks >= 60)
                .forEach(s -> System.out.println("  " + s));
        System.out.println();

        // collect to new list
        System.out.println("2. collect() - names of top students:");
        List<String> topNames = students.stream()
                .filter(s -> s.marks >= 70)
                .map(s -> s.name)
                .collect(Collectors.toList());
        System.out.println("  Names: " + topNames);
        System.out.println();

        // count
        System.out.println("3. count() - students with marks < 65:");
        long failCount = students.stream()
                .filter(s -> s.marks < 65)
                .count();
        System.out.println("  Count: " + failCount);
        System.out.println();

        // reduce - highest marks
        System.out.println("4. reduce() - highest marks:");
        Optional<Integer> highest = students.stream()
                .map(s -> s.marks)
                .reduce((m1, m2) -> m1 > m2 ? m1 : m2);
        System.out.println("  Highest marks: " + highest.get());
        System.out.println();

        // Explanation
        System.out.println("=== Explanation ===");
        System.out.println("Terminal operations finalize the stream pipeline because:");
        System.out.println("- They trigger processing of all intermediate operations.");
        System.out.println("- After a terminal operation, the stream cannot be reused.");
        System.out.println("- They produce a non-stream result (value, collection, or void).");
        System.out.println("- Examples: forEach(), collect(), count(), reduce()");
    }
}