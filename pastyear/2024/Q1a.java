import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        int pos = 0, neg = 0, zeros = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an Integer: (X to stop)");
        String input = sc.next();
        while (!input.equals("X"))
        {
            try {
                int num = Integer.parseInt(input);
                if (num > 0)
                    pos++;
                else if (num < 0)
                    neg++;
                else
                    zeros++;
            } catch (NumberFormatException e) {
                System.out.println("Not an Integer");
            }
            System.out.println("Enter an Integer: (X to stop)");
            input = sc.next();
        }
        sc.close(); 

        System.out.println("Positive integer count: " + pos);
        System.out.println("Negative integer count: " + neg);
        System.out.println("Zeros count: " + zeros);
    }
}
