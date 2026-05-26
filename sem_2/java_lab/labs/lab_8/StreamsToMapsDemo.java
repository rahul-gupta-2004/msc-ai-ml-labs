package sem_2.java_lab.labs.lab_8;

import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + " | " + name + " | $" + salary;
    }
}

public class StreamsToMapsDemo {
    public static void main(String[] args) {

        // Creating a list of employees
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice", 55000),
                new Employee(102, "Bob", 48000),
                new Employee(103, "John", 72000),
                new Employee(104, "Emma", 61000),
                new Employee(105, "David", 39000));

        System.out.println("=== Original List of Employees ===");
        employees.forEach(System.out::println);
        System.out.println();

        // Part 1: List to Map (id -> name)
        System.out.println("=== Part 1: List to Map (ID -> Name) ===");
        Map<Integer, String> empMap = employees.stream()
                .collect(Collectors.toMap(
                        e -> e.id, // key mapper
                        e -> e.name, // value mapper
                        (old, newVal) -> old // in case of duplicate keys
                ));

        System.out.println("Employee Map (ID -> Name):");
        empMap.forEach((id, name) -> System.out.println(id + " -> " + name));
        System.out.println();

        // Part 2: Map to Stream and filter/sort
        System.out.println("=== Part 2: Map to Stream with Filter and Sort ===");
        System.out.println("Filtering employees with salary > 50000 and sorting by salary:\n");

        // Convert map entries to stream, but we need salary info
        // So we convert Map<Integer, String> back to Employee list using original data
        // Alternative: convert map entries and lookup from original? Simpler: use
        // original list
        // Better approach: Stream from original employees list

        System.out.println("Method 1: Using original employee list directly:");
        List<Employee> highPaid = employees.stream()
                .filter(e -> e.salary > 50000)
                .sorted((e1, e2) -> Double.compare(e1.salary, e2.salary))
                .collect(Collectors.toList());

        highPaid.forEach(System.out::println);
        System.out.println();

        // Part 3: Converting Map back to Stream of entries
        System.out.println("=== Part 3: Map EntrySet to Stream ===");
        System.out.println("Iterating over Map using Stream (forEach):");
        empMap.entrySet().stream()
                .filter(entry -> entry.getKey() > 102)
                .forEach(entry -> System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue()));
        System.out.println();

        // Part 4: Advanced - Map of id -> full Employee object
        System.out.println("=== Part 4: Map of ID -> Employee Object ===");
        Map<Integer, Employee> empFullMap = employees.stream()
                .collect(Collectors.toMap(e -> e.id, e -> e));

        System.out.println("Filtering map stream where salary > 60000:");
        empFullMap.entrySet().stream()
                .filter(entry -> entry.getValue().salary > 60000)
                .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(e -> e.salary)))
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
        System.out.println();

        // Summary
        System.out.println("=== Summary ===");
        System.out.println("1. List -> Map: Used Collectors.toMap()");
        System.out.println("2. Map -> Stream: Used entrySet().stream()");
        System.out.println("3. Filtering and sorting work same on map streams");
        System.out.println("4. Can also convert back to List from Map if needed");
    }
}