import java.util.*;

public class L5Q3 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int n, temp, sum;
        System.out.print("Enter number of employees: ");
        n = sc.nextInt();
        // int[] hours = new int[n];
        for (int i = 0; i < n; i++)
        {
            sum = 0;
            System.out.println("Employee " + (i + 1));
            System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat\t");
            for (int j = 0; j < 7; j++)
            {
                temp = rand.nextInt(8) + 1;
                System.out.print(temp + "\t");
                sum += temp;
            }
            System.out.println("\nTotal working hours: " + sum);
            System.out.println();
        }

        sc.close();
    }
}
