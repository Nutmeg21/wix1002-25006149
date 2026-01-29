import java.util.*;

public class Q2b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter age: ");
            int age = sc.nextInt();
            if (age < 18)
            {
                sc.close();
                throw new InvalidAgeException();
            }   
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException()
    {
        super("Age is less than 18");
    }
}
