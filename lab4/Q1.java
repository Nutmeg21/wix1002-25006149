import java.util.*;

public class Q1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an Integer: ");
        int input = sc.nextInt();
        System.out.print("The factors are: ");
        for (int i = 1; i <= input/2; i++)
        {
            if (input % i == 0)
                System.out.print(i + " ");
        }
        System.out.println(input);
        sc.close();
    }
}