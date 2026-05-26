package sem_2.java_lab.labs.lab_9;

// Main.java
import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        System.out.println("=== JPA CRUD Operations ===\n");

        // 1. INSERT operation
        System.out.println("1. Inserting students...");
        tx.begin();
        Student s1 = new Student("Alice", 85.5);
        Student s2 = new Student("Bob", 72.0);
        Student s3 = new Student("John", 90.3);
        em.persist(s1);
        em.persist(s2);
        em.persist(s3);
        tx.commit();
        System.out.println("Inserted: " + s1);
        System.out.println("Inserted: " + s2);
        System.out.println("Inserted: " + s3);
        System.out.println();

        // 2. RETRIEVE operation (find by id)
        System.out.println("2. Retrieving student with id = 2...");
        Student found = em.find(Student.class, 2);
        System.out.println("Retrieved: " + found);
        System.out.println();

        // 3. UPDATE operation
        System.out.println("3. Updating student with id = 2 (change name to Robert, marks to 78.5)...");
        tx.begin();
        found.setName("Robert");
        found.setMarks(78.5);
        em.merge(found);
        tx.commit();
        System.out.println("Updated: " + em.find(Student.class, 2));
        System.out.println();

        // 4. DELETE operation
        System.out.println("4. Deleting student with id = 3...");
        tx.begin();
        Student toDelete = em.find(Student.class, 3);
        em.remove(toDelete);
        tx.commit();
        System.out.println("Deleted student with id = 3");
        System.out.println();

        // 5. Display all remaining students
        System.out.println("5. All remaining students after delete:");
        Query query = em.createQuery("SELECT s FROM Student s");
        List<Student> allStudents = query.getResultList();
        for (Student s : allStudents) {
            System.out.println(s);
        }

        // Close connections
        em.close();
        emf.close();
    }
}