import java.util.*;

public class Q1b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter positive integer, n: ");
        double n = sc.nextInt();
        double sum = 0;
        for (double i = 1; i <= n; i++)
        {
            sum += 1/i;
        }
        System.out.println("Sum of series 1/n: " + sum);
        sc.close();
    }
}
