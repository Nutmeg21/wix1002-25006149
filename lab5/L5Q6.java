import java.util.*;

public class L5Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row;
        
        System.out.print("Enter the number of row of Pascal Triangle to generate: ");
        row = sc.nextInt();
        int[][] pascal = new int[row][row];

        System.out.println("The Pascal Triangle with " + row + " row(s)");

        if (row > 0)
        {
            pascal[0][0] = 1;
            for (int j = 1; j < row; j++)
            {
                pascal[0][j] = 0;
            }
        }

        for (int i = 1; i < row; i++)
        {
            pascal[i][0] = 1;
            for (int j = 1; j <= i; j++)
            {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < row; j++)
            {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
