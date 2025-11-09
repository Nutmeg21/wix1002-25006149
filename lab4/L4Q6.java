import java.util.*;

public class L4Q6
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int num, digit = 0;
        num = Math.abs(rand.nextInt());
        System.out.print("Number of digits in " + num);
        while (num > 0)
        {
            digit ++;
            num /= 10;
        }
        System.out.println(": " + digit);
    }
}
