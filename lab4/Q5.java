import java.util.*;

public class Q5
{
    public static void main(String[] args)
    {
        int p1 = 0, p2 = 0;
        while (p1 < 100 && p2 < 100)
        {
            p1 = roll(p1, 1);
            if (p1 >= 100)
            {
                System.out.println("Player 1 wins!");
                break;
            }

            p2 = roll(p2, 2);
            if (p2 >= 100)
            {
                System.out.println("Player 2 wins!");
                break;
            }

        }
    }
    
    public static int roll(int currentScore, int playerId)
    {
        Random rand = new Random();
        int roll;
        do
        {
            roll = rand.nextInt(6) + 1;
            currentScore += roll;
            System.out.println("Player " + playerId + ": " + currentScore);
        }
        while (roll == 6 && currentScore < 100);
        return currentScore;
    }
}
