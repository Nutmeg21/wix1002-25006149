import java.util.*;

public class L4Q2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int sum = 0, n;

        System.out.print("Enter an integer: ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                sum += j;
            }
        }
        System.out.println("Sum of series: " + sum);
        sc.close();
    }
}
