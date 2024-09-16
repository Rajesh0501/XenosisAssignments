package XenosisFourthWeekAssignment;
import java.util.ArrayList;
import java.util.Scanner;


class StudentManagement {
    ArrayList<String> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    public void addStudent(String student) {
        students.add(student);
        System.out.println("Student added-> " + student);
    }

    public void removeStudent(String student) {
        if (students.contains(student)) {
            students.remove(student);
            System.out.println("Student removed -> " + student);
        } else {
            System.out.println("Student not found -> " + student);
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list");
        } else {
            System.out.println("List of Students");
            for (String student : students) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String nameToAdd = scanner.nextLine();
                    sm.addStudent(nameToAdd);
                    break;

                case 2:
                    System.out.print("Enter student name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    sm.removeStudent(nameToRemove);
                    break;

                case 3:
                    sm.displayStudents();
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
