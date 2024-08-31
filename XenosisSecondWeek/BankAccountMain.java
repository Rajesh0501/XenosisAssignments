package XenosisSecondWeek;

import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(5000);
        Scanner scanner  = new Scanner(System.in);
        boolean exit = false;

       while (!exit){

           System.out.println("\nChoose an option:");
           System.out.println("1. Deposit");
           System.out.println("2. Withdraw");
           System.out.println("3. Display Balance");
           System.out.println("4. Exit");
           System.out.print("Enter your choice: ");

           int choice = scanner.nextInt();

           switch (choice) {
               case 1:
                   System.out.print("Enter amount to deposit: ");
                   double depositAmount = scanner.nextDouble();
                   bankAccount.deposit(depositAmount);
                   break;

               case 2:
                   System.out.print("Enter amount to withdraw: ");
                   double withdrawAmount = scanner.nextDouble();
                   bankAccount.withdrawAmount(withdrawAmount);
                   break;

               case 3:
                   bankAccount.displayBalance();
                   break;

               case 4:
                   exit = true;
                   System.out.println("Exiting the application.");
                   break;

               default:
                   System.out.println("Invalid choice. Please select a valid option.");
           }
       }
    }
}
