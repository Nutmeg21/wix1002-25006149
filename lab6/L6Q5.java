import java.util.*;

public class L6Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int score = 0, ans = 0;
        do {
            System.out.println("Enter negative number to quit.");
            int num1 = rand.nextInt(11) + 1, num2 = rand.nextInt(12) + 1;
            System.out.print(num1 + " * " + num2 + " = ");
            ans = sc.nextInt();
            score += checkAns(num1, num2, ans);
        } while (ans >= 0);
        System.out.println("Your score is " + score);
        sc.close();
    }

    public static int checkAns(int num1, int num2, int ans)
    {
        int score = num1 * num2 == ans ? 1 : 0;
        return score; 
    }
}