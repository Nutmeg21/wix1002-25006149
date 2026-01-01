import java.util.*;

public class L8Q2 {
    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        a.deposit();
        a.withdraw();
        a.withdraw();
    }
}

class BankAccount {
    String name;
    double currentBalance = 0;

    public BankAccount()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name / IC / Passport number: ");
        name = sc.nextLine();
        System.out.print("Enter deposit amount: ");
        currentBalance = sc.nextDouble();
    }

    public void deposit()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        double deposit = sc.nextDouble();
        currentBalance += deposit;
        System.out.println("Current balance: RM" + currentBalance);;
    }

    public void withdraw()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double withdraw = sc.nextDouble();
        if (currentBalance - withdraw < 0)
        {
            System.out.println("Cannot withdraw. Balance not enough");
            System.out.println("Current balance: RM" + currentBalance);;
        }
        else
        {
            currentBalance -= withdraw;
            System.out.println("Current balance: RM" + currentBalance);;
        }
    }
}
