package XenosisFirstWeekAssignment;

import java.util.Scanner;

public class Calculator {
    public static int performAddition(int n1,int n2){
        return n1+n2;
    }

    public static int performSubtraction(int n1 ,int n2){
        return n1 -n2;
    }

    public static long performMultiply(int n1 ,int n2){
        return n1*n2;
    }

    public static double performDivide(int n1 ,int n2){
        return n1/n2;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first Number");
        int n1 = sc.nextInt();

        System.out.println("Enter operation in Which to want to perform");
        char operation = sc.next().charAt(0);

        System.out.println("Enter the Second Number");
        int n2 = sc.nextInt();


        switch (operation){
            case '+':
                System.out.println("addition of two number :"+ performAddition(n1,n2));
                break;

            case '-':
                System.out.println("Subtraction of two number :"+ performSubtraction(n1,n2));
                break;

            case '*':
                System.out.println("Multiply of two number :"+ performMultiply(n1,n2));
                break;

            case '/':
                System.out.println("Divide of two number :"+ performDivide(n1,n2));
                break;

            default:
                System.out.println("input is Invalid");

        }


    }
}
