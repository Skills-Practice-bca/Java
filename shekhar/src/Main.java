import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement sms = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    sms.addStudent(new Student(id, name, age));
                    break;
                case "2":
                    System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.nextLine();
                    sms.deleteStudent(deleteId);
                    break;
                case "3":
                    sms.displayStudents();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("4"));

        scanner.close();
    }
}
