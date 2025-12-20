import java.util.*;
import java.io.*;

public class L7Q1 {
    public static void main(String[] args) {
        String[][] courses = {{"WXES1116", "Programming I"}, {"WXES1115", "Data Structure"}, {"WXES1110", "Operating System"}, {"WXES1112", "Computing Mathematics I"}};
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("coursename.dat"));
            for(int i = 0; i < courses.length; i++)
            {
                output.writeUTF(courses[i][0]);
                output.writeUTF(courses[i][1]);
            }
            output.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course code: ");
        String courseCode = sc.next().strip().toUpperCase();
        boolean found = false;
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream("coursename.dat"));
            while(reader.available() > 0)
            {
                String code = reader.readUTF();
                String name = reader.readUTF();

                if(code.equals(courseCode))
                {
                    System.out.println("Course Name: " + name);
                    found = true;
                    break;
                }
            }
            if(!found)
            {
                System.out.println("Courde code not found.");
            }
            sc.close();
            reader.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
