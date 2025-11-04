import java.util.*;

public class L5Q1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int size, highest = 0, lowest = 100, sum = 0;
        double avg;

        System.out.print("Enter number of students: ");
        size = sc.nextInt();
        int[] scores = new int[size];
        
        for (int i = 0; i < size; i++)
        {
            scores[i] = rand.nextInt(101);
            sum += scores[i];
            highest = scores[i] > highest ? scores[i] : highest;
            lowest = scores[i] < lowest ? scores[i] : lowest;
            System.out.print(scores[i] + " ");
        }
        System.out.println();
        avg = (double) sum / size;
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
        System.out.println("Average: " + avg);

        sc.close();
    }    
}
