package XenosisFourthWeekAssignment;

import java.util.Scanner;


// Custom Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}


public class ExceptionHandlingDemo {

    // Method that can throw custom InvalidAgeException
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        } else {
            System.out.println("Valid age.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // ArithmeticException example
            System.out.print("Enter a number to divide 100: ");
            int divisor = scanner.nextInt();
            int result = 100 / divisor;  // May throw ArithmeticException
            System.out.println("Result of division: " + result);

            // NullPointerException example
            String str = null;
            System.out.println("Length of the string: " + str.length());  // May throw NullPointerException

            // Custom exception example
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            checkAge(age);  // May throw InvalidAgeException

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero. " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: Null reference encountered. " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("Custom Error: " + e.getMessage());
        } catch (Exception e) {
            // Catch-all for any other unexpected exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Exception handling complete.");
        }

        scanner.close();
    }
}
