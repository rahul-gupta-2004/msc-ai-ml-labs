// Base class demonstrating access specifiers
class Animal {
    private int id; // private access
    protected String name; // protected access
    public String type; // public access

    // Constructor
    public Animal(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    // Method using StringBuffer
    public void showId() {
        StringBuffer sb = new StringBuffer("ID: ");
        sb.append(id);
        System.out.println(sb.toString());
    }

    // method to be overloaded
    public void sound() {
        System.out.println("Animal makes sound");
    }
}

// Derived class with inheritance
class Dog extends Animal implements Playable {
    private String breed;

    // Constructor overloading
    public Dog(int id, String name, String type, String breed) {
        super(id, name, type);
        this.breed = breed;
    }

    public Dog(int id, String name, String type) {
        super(id, name, type);
        this.breed = "Unknown";
    }

    // Method overloading
    public void sound() {
        System.out.println(name + " barks");
    }

    public void sound(String extraSound) {
        System.out.println(name + " barks and " + extraSound);
    }

    // Implementing interface method
    public void play() {
        System.out.println(name + " is playing");
    }

    public void displayBreed() {
        System.out.println("Breed: " + breed);
    }
}

// Interface
interface Playable {
    void play();
}

// Generic class
class Box<T> {
    T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

// Multithreading using Runnable
class MyTask implements Runnable {
    String taskName;

    public MyTask(String name) {
        this.taskName = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " - step " + i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}

// Main class
public class lab_1 {
    public static void main(String[] args) {

        // Classes, objects, access specifiers
        Dog d1 = new Dog(101, "Bruno", "Pet", "Labrador");
        d1.showId(); // private id accessed via method
        System.out.println("Name: " + d1.name); // protected accessible in child
        System.out.println("Type: " + d1.type); // public

        // Constructor overloading and method overloading
        Dog d2 = new Dog(102, "Max", "Pet");
        d2.sound();
        d2.sound("whines");

        // Inheritance and interface
        d1.play();

        // Multithreading
        System.out.println("\n--- Multithreading ---");
        Thread t1 = new Thread(new MyTask("Thread A"));
        Thread t2 = new Thread(new MyTask("Thread B"));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }

        // Generics
        System.out.println("\n--- Generics ---");
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello Generics");
        System.out.println("String Box: " + stringBox.getItem());

        Box<Integer> intBox = new Box<>();
        intBox.setItem(100);
        System.out.println("Integer Box: " + intBox.getItem());

        // Lambda expression
        System.out.println("\n--- Lambda Example ---");
        Runnable lambdaTask = () -> {
            System.out.println("Lambda thread running...");
        };
        Thread lambdaThread = new Thread(lambdaTask);
        lambdaThread.start();
        try {
            lambdaThread.join();
        } catch (Exception e) {
        }
    }
}