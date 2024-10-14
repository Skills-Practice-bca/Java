import java.io.*;
import java.util.*;

class StudentManagement {
    private List<Student> students;
    private static final String FILE_NAME = "students.dat";

    public StudentManagement() {
        students = new ArrayList<>();
        loadStudents();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
    }

    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
        saveStudents();
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.err.println("Error saving student records: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous records found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading student records: " + e.getMessage());
        }
    }
}
