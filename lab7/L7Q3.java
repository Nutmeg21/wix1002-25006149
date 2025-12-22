import java.util.*;
import java.io.*;

public class L7Q3 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new FileInputStream("./lab7/datasets/lecturer.txt"));
            PrintWriter output = new PrintWriter(new FileOutputStream("./lab7/reverse.txt"));
            while(input.hasNext())
            {
                String original = input.nextLine();
                StringBuilder reversed = new StringBuilder(original);
                reversed.reverse();
                output.println(reversed);
            }
            input.close();
            output.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
