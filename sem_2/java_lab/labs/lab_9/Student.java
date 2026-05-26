package sem_2.java_lab.labs.lab_9;

// Student.java
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "marks")
    private double marks;

    // Default constructor (required by JPA)
    public Student() {}

    // Parameterized constructor
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // For displaying student details
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
    }
}