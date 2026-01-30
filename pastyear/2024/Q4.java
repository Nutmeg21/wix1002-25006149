import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        int[][] seatingPlan = initializeSeatingPlan();
        int[] results = analyzeSeating(seatingPlan);
        System.out.println("Total Occupied Seats: " + results[1]);
        System.out.println("Row with Most Occupied Seats: Row " + results[0]);
        System.out.println("Seating Plan:");
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                System.out.print(seatingPlan[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] initializeSeatingPlan()
    {
        Random rand = new Random();
        int[][] seatingPlan = new int[5][5];
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                seatingPlan[i][j] = rand.nextInt(2);
            }
        }
        return seatingPlan;
    }

    public static int[] analyzeSeating(int[][] seatingPlan)
    {
        int max = 0;
        int row = 0;
        int rowHighest = -1;
        int occupied = 0;

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (seatingPlan[i][j] == 1)
                {
                    occupied++;
                    row++;
                }
            }
            if (row > max)
            {
                max = row;
                rowHighest = i;
            }
            row = 0;
        }
        int results[] = {rowHighest + 1, occupied};
        return results;
    }
}
