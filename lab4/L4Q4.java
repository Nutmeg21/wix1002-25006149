import java.util.*;

public class L4Q4 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int year, day, startMay, startAug;

        System.out.print("Enter year: ");
        year = sc.nextInt();
        System.out.println("0 - Sunday\n1 - Monday\n2 - Tuesday\n3 - Wednesday\n4 - Thursday\n5 - Friday\n6 - Saturday");
        System.out.print("Enter first day of year: ");
        day = sc.nextInt();
        System.out.println();

        // Leap year
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
        {
            startMay = day + 2;
            startAug = day + 3;
        }
        else
        {
            startMay = day + 1;
            startAug = day + 2;
        }

        // Check if start indexes exceed 6
        startMay = startMay > 6 ? startMay -= 7 : startMay;
        startAug = startAug > 6 ? startAug -= 7 : startAug;

        System.out.println("May " + year);
        calendar(startMay);
        System.out.println("Aug " + year);
        calendar(startAug);

        sc.close();
    }

    // Calendar method
    public static void calendar(int start)
    {
        int currentDay = start, daysInMonth = 31;
        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
        for (int i = 0; i < start; i++)
        {
            System.out.print("\t");
        }
        for (int i = 1; i <= daysInMonth; i++)
        {
            if (currentDay % 7 == 0 && currentDay != 0)
            {
                System.out.println();
            }
            System.out.print(i + "\t");
            currentDay++;
        }
        System.out.println("\n");
    }
}
