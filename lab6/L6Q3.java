import java.util.*;

public class L6Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++)
            arr[i] = reverse(sc.nextInt());

        System.out.println("Reversed: ");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        sc.close();
    }
    public static int reverse(int num)
    {
        int reverse = 0;
        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit; 
            num /= 10;
        }
        return reverse;
    }
}