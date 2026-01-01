import java.util.*;
import java.io.*;

public class L9Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, gender, dob;
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter gender: ");
        gender = sc.nextLine();
        System.out.print("Enter date of birth: ");
        dob = sc.nextLine();
        Lecturer lecturer = new Lecturer(name, gender, dob);
        lecturer.display();
        lecturer.displayCourse();

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

class Lecturer extends PersonProfile {
    ArrayList<String> courseCode = new ArrayList<>();
    ArrayList<String> courseName = new ArrayList<>();
    ArrayList<Integer> semester = new ArrayList<>();
    ArrayList<Integer> session = new ArrayList<>();
    ArrayList<Double> creditHour = new ArrayList<>();
    ArrayList<Integer> studentNum = new ArrayList<>();
    String fileName;

    public Lecturer(String lecturerName, String lecturerGender, String lecturerDob)
    {
        super(lecturerName ,lecturerGender, lecturerDob);
        
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
                creditHour.add(input.nextDouble());
                studentNum.add(input.nextInt());
                creditHour.set(i, calculateCreditHour(studentNum.get(i), creditHour.get(i)));
                i++;
                input.nextLine();
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public double calculateCreditHour(int studentNum, double creditHour)
    {
        if (studentNum >= 150)
            return creditHour * 3;
        if (studentNum >= 100)
            return creditHour * 2;
        if (studentNum >= 50)
            return creditHour * 1.5;
        return creditHour;
    }

    public void displayCourse()
    {
        for (int i = 0; i < courseCode.size(); i++)
        {
            System.out.println();
            System.out.println("Course code: " + courseCode.get(i));
            System.out.println("Course name: " + courseName.get(i));
            System.out.println("Semester " + semester.get(i) + ", Session " + session.get(i));
            System.out.println("Credit hours: " + creditHour.get(i));
        }
    }
}