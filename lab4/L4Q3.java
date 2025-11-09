import java.util.*;

public class L4Q3 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int input, sum = 0, sqrSum = 0, min = Integer.MAX_VALUE, max = 0, n = 0;
        double avg = 0, variance = 0, s = 0;
        System.out.print("Enter a score [negative score to quit]:");
        input = sc.nextInt();
        while (input >= 0)
        {
            sum += input;
            sqrSum += (input * input);
            if (input < min)
                min = input;
            if (input > max)
                max = input;
            n++;
            System.out.print("Enter a score [negative score to quit]:");
            input = sc.nextInt();
        }
        avg = (double)sum / n;
        variance = (sqrSum - (sum * sum) / n) / (n - 1);
        s = Math.sqrt(variance);
        System.out.println(variance);
        System.out.println("Minimum Score: " + min);
        System.out.println("Maximum Score: " + max);
        System.out.printf("Average Score: %.2f\n", avg);
        System.out.printf("Standard Deviation: %.2f\n", s);

        sc.close();
    }
}
