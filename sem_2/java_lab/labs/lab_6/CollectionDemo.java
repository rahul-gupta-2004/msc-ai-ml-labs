import java.util.*;

// Student class
class Student {
    int id;
    String name;
    double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // For displaying student details
    public String toString() {
        return id + " | " + name + " | " + marks;
    }
}

public class CollectionDemo {
    public static void main(String[] args) {

        // Part 1: Using ArrayList
        System.out.println("=== Using ArrayList ===");
        ArrayList<Student> list = new ArrayList<>();

        // Insertion
        System.out.println("1. Insertion:");
        list.add(new Student(3, "Alice", 85.5));
        list.add(new Student(1, "Bob", 72.0));
        list.add(new Student(2, "John", 90.3));
        System.out.println("After insertion:");
        displayList(list);

        // Deletion
        System.out.println("\n2. Deletion (remove Bob):");
        list.removeIf(s -> s.name.equals("Bob"));
        displayList(list);

        // Searching
        System.out.println("\n3. Searching (find John):");
        for (Student s : list) {
            if (s.name.equals("John")) {
                System.out.println("Found: " + s);
            }
        }

        // Sorting by marks
        System.out.println("\n4. Sorting by marks:");
        Collections.sort(list, (s1, s2) -> Double.compare(s1.marks, s2.marks));
        displayList(list);

        // Part 2: Using TreeMap (sorted by ID automatically)
        System.out.println("\n\n=== Using TreeMap ===");
        TreeMap<Integer, Student> map = new TreeMap<>();

        // Insertion
        System.out.println("1. Insertion:");
        map.put(3, new Student(3, "Alice", 85.5));
        map.put(1, new Student(1, "Bob", 72.0));
        map.put(2, new Student(2, "John", 90.3));
        System.out.println("TreeMap (sorted by ID):");
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Deletion
        System.out.println("\n2. Deletion (remove ID 1):");
        map.remove(1);
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Searching by ID
        System.out.println("\n3. Searching (find ID 2):");
        Student found = map.get(2);
        if (found != null) {
            System.out.println("Found: " + found);
        }

        // Comparison
        System.out.println("\n=== Comparison ===");
        System.out.println("ArrayList:");
        System.out.println("  - Maintains insertion order");
        System.out.println("  - Searching by name is O(n)");
        System.out.println("  - Sorting required manually");
        System.out.println("  - Good for index-based access");

        System.out.println("\nTreeMap:");
        System.out.println("  - Maintains sorted order by key (ID)");
        System.out.println("  - Searching by ID is O(log n)");
        System.out.println("  - Always sorted, no extra sorting needed");
        System.out.println("  - Good for key-value pair operations");
    }

    // Helper method to display ArrayList
    public static void displayList(ArrayList<Student> list) {
        for (Student s : list) {
            System.out.println(s);
        }
    }
}