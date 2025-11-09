import java.util.*;

public class L4Q7 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);   
        double principal, interestRate;
        int numMonths;

        System.out.print("Enter principal amount: ");
        principal = sc.nextDouble();
        System.out.print("Enter interest in %: ");
        interestRate = sc.nextDouble();
        System.out.print("Enter total number of month(s): ");
        numMonths = sc.nextInt();

        table(principal, interestRate, numMonths);

        sc.close();
    }   
    
    public static void table(double principal, double interestRate, int numMonths)
    {
        double monthlyPayment, portionDue, interestDue, remainingBalance, totalInterest = 0;
        System.out.println("Month\t\tMonthly Payment\t\tPrincipal\t\tInterest\t\tUnpaid Balance\t\tTotal Interest");
        for (int i = 1; i <= numMonths; i++)
        {
            monthlyPayment = (principal * interestRate / (12 * 100)) / (1 - Math.pow(1 + interestRate / (12 * 100), -numMonths));
            portionDue = monthlyPayment * Math.pow(1 + interestRate / (12 * 100), -(1 + numMonths - i));
            interestDue = monthlyPayment - portionDue;
            remainingBalance = interestDue / (interestRate / (12 * 100)) - portionDue;
            totalInterest += interestDue;

            System.out.print(i + "\t\t");
            System.out.printf("%.2f\t\t\t", monthlyPayment);
            System.out.printf("%.2f\t\t\t", portionDue);
            System.out.printf("%.2f\t\t\t", interestDue);
            System.out.printf("%.2f\t\t\t", remainingBalance);
            System.out.printf("%.2f\n", totalInterest);
        }        

    }
}
