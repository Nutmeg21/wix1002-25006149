import java.util.*;
import java.io.*;

public class L7Q4 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new FileInputStream("datasets/lecturer.txt"));
            int lineCnt = 0, wordCnt = 0, charCnt = 0;
            while(input.hasNext())
            {
                String line = input.nextLine();
                String[] words = line.split(" ");
                char[] chars = line.replace(" ", "").toCharArray();
                lineCnt ++;
                wordCnt += words.length;
                charCnt += chars.length;
            }
            input.close();

            System.out.println("Number of lines: " + lineCnt);
            System.out.println("Number of words: " + wordCnt);
            System.out.println("Number of characters: " + charCnt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
