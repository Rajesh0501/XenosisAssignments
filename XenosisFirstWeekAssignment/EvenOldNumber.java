package XenosisFirstWeekAssignment;

import java.util.Scanner;

public class EvenOldNumber {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter a number ");
          int n = sc.nextInt();
           if (n%2==0){
               System.out.println("this number is Even number :"+n);
           }
           else {
               System.out.println("this number id not Even number :"+n);
           }
        }
}
