import java.util.*;
import java.io.*;

public class L9Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, gender, dob;
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter gender: ");
        gender = sc.nextLine();
        System.out.print("Enter date of birth: ");
        dob = sc.nextLine();
        Student student = new Student(name, gender, dob);
        student.display();
        student.displayGrade();
        sc.close();
    }
}

class PersonProfile {
    String name;
    String gender;
    String dob;
    Scanner sc = new Scanner(System.in);

    public PersonProfile(String personName, String personGender, String personDob)
    {
        name = personName;
        gender = personGender;
        dob = personDob;
    }

    public void display()
    {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + dob);
    }
}

class Student extends PersonProfile {
    ArrayList<String> courseCode = new ArrayList<>();
    ArrayList<String> courseName = new ArrayList<>();
    ArrayList<Integer> semester = new ArrayList<>();
    ArrayList<Integer> session = new ArrayList<>();
    ArrayList<Integer> mark = new ArrayList<>();
    ArrayList<String> grade = new ArrayList<>();
    String fileName;

    public Student(String studentName, String studentGender, String studentDob)
    {
        super(studentName ,studentGender, studentDob);
        
        System.out.println("Enter file name: ");
        fileName = sc.next();

        try {
            Scanner input = new Scanner(new FileInputStream(fileName));
            int i = 0;
            while (input.hasNext())
            {
                courseCode.add(input.nextLine());
                courseName.add(input.nextLine());
                semester.add(input.nextInt());
                session.add(input.nextInt());
                mark.add(input.nextInt());
                grade.add(getGrade(mark.get(i)));
                input.nextLine();
                i++;
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getGrade(int mark)
    {
        if (mark >= 85)
            return "A";
        if (mark >= 75)
            return "A-";
        if (mark >= 70)
            return "B+";
        if (mark >= 65)
            return "B";
        if (mark >= 60)
            return "B-";
        if (mark >= 55)
            return "C+";
        if (mark >= 50)
            return "C";
        if (mark >= 45)
            return "D";
        if (mark >= 35)
            return "E";
        return "F";
    }

    public void displayGrade()
    {
        for (int i = 0; i < courseName.size(); i++)
        {
            System.out.println("Course: " + courseName.get(i));
            System.out.println("Grade: " + grade.get(i));
        }
    }
}