package XenosisFourthWeekAssignment;
import java.util.HashMap;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {

        HashMap<Integer, Employee> employees = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Retrieve Employee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee department: ");
                    String department = scanner.nextLine();

                    employees.put(id, new Employee(id, name, department));
                    System.out.println("Employee added.");
                    break;

                case 2:
                    System.out.print("Enter employee ID to retrieve: ");
                    int empId = scanner.nextInt();

                    Employee employee = employees.get(empId);
                    if (employee != null) {
                        System.out.println("Employee Details: " + employee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}

