import java.util.*;

public class L5Q4 {
    public static void main(String[] args) {
        System.out.println("3 by 3 Matrix");
        int[][] matrix =
        {
            {1, 5, 7},
            {3, 6, 9},
            {5, 3, 8}
        };

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("After rotates 90 degrees clockwise");

        for (int i = 2; i >= 0; i--)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }   
}
