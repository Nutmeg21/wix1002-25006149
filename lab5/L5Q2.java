import java.util.*;

public class L5Q2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < 10; i++)
        {
            do {
                numbers[i] = rand.nextInt(21);
            } while (duplicate(numbers, i));

            System.out.println(numbers[i]);
        }
        
    }

    public static boolean duplicate(int[] numbers, int curr)
    {
        for (int i = 0; i < curr; i++)
        {
            if (numbers[i] == numbers[curr])
            {
                return true;
            }
        }
        return false;
    }
}
