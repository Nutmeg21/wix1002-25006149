import java.util.*;

public class L5Q5 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int[] num = new int[20];

        int cntLinear = 0, cntBin = 0, search;

        //Generate random array
        for (int i = 0; i < 20; i++)
        {
            num[i] = rand.nextInt(101);
        }
        System.out.println("A list of 20 random integer within 0 to 100");
        printArray(num);

        //Insertion sort
        for (int i = 1; i < 20; i++)
        {
            int x = num[i];
            int j = i - 1;
            while (j >= 0 && num[j] < x)
            {
                num[j + 1] = num[j];
                j--;
            }
            num[j + 1] = x;
        }
        System.out.println("Array in descending order");
        printArray(num);

        System.out.print("Enter a number to search: ");
        search = sc.nextInt();

        //Linear search
        for (int i = 0; i < 20; i++)
        {
            cntLinear++;
            if (num[i] == search)
            {
                System.out.println(search + " found");
                System.out.println("Linear search - " + cntLinear + " loop(s)");
                break;
            }
        }

        //Binary search
        int low = 0, high = 19;

        while (low <= high)
        {
            cntBin++;
            int mid = low + (high - low) / 2;
            if (search > num[mid])
            {
                high = mid - 1;
            }
            else if (search < num[mid])
            {
                low = mid + 1;
            }
            else
            {
                System.out.println(search + " found");
                System.out.println("Binary search - " + cntBin + " loop(s)");
                break;
            }
        }

        sc.close();
    }

    public static void printArray(int[] num)
    {
        for (int i = 0; i < 20; i++)
        {
            System.out.print(num[i]);
            if (i < 19)
                System.out.print(" , ");
            else    
                System.out.print("\n");
        }
    }
}
