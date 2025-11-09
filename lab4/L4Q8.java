import java.util.*;

public class L4Q8
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int n = rand.nextInt(101);
        int num = 2;
       
        System.out.println("First " + n + " prime numbers:");
        while (n > 0)
        {
            if (isPrime(num))
            {
                System.out.println(num);
                n--;
            }
            num++;
        }
    }    

    public static boolean isPrime(int num)
    {
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
