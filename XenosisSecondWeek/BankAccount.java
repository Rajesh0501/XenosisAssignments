package XenosisSecondWeek;

public class BankAccount {
    public double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double account){
         if (account>0){
             balance += account;
             System.out.println("Deposit amount : "+ account);
         }
         else {
             System.out.println("Enter Valid Amount ");
         }
    }

    public void withdrawAmount(double amount){
        if (amount>0){
            balance -= amount;
            System.out.println("WithDraw Amount :"+ amount);
        }
        else {
            System.out.println("Enter valid Amount");
        }
    }

    public void displayBalance(){
        System.out.println("Your Account Balance  :"+ balance);
    }


}
