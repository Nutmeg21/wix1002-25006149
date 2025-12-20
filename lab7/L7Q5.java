import java.util.*;
import java.io.*;

public class L7Q5 {
    public static void main(String[] args) {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("datasets/person.dat"));
            while(input.available() > 0)
            {
                int recordTotal = input.readInt();
                String[][] persons = new String[recordTotal][3];
                for(int i = 0; i < recordTotal; i++)
                {
                    persons[i][0] = input.readUTF();
                    persons[i][1] = Integer.toString(input.readInt());
                    persons[i][2] = Character.toString(input.readChar());
                }
                Arrays.sort(persons, (a, b) -> a[0].compareTo(b[0]));
                for(String[] person : persons)
                {
                    System.out.println("Name: " + person[0]);
                    System.out.println("Age: " + person[1]);
                    String gender = person[2].equals("M") ? "Male" : "Female";
                    System.out.println("Gender: " + gender);
                }
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
