import java.util.*;

public class L8Q4 {
    public static void main(String[] args) {
        Fraction a = new Fraction();
        a.set();
        a.get();
        a.simplest();
    }
}

class Fraction {
    int numerator;
    int denominator;
    Scanner sc = new Scanner(System.in);

    public Fraction()
    {
        numerator = 0;
        denominator = 1;
    }

    public void set()
    {
        System.out.print("Enter numerator: ");
        numerator = sc.nextInt();
        System.out.print("Enter denominator: ");
        denominator = sc.nextInt();
    }

    public void get()
    {
        System.out.println("Numerator: " + numerator);
        System.out.println("Denominator: " + denominator);
    }

    public void simplest()
    {        
        int gcd = gcd(numerator, denominator);
        int simpleNum = numerator / gcd;
        int simpleDen = denominator / gcd;
        System.out.println("Simplest fraction: " + simpleNum + "/" + simpleDen);
    }

    public int gcd(int a, int b)
    {
        if (b > a)
        {
            // Bitwise operation to swap a and b
            a = a ^ b; 
            b = a ^ b; 
            a = a ^ b;
        }
        
        int remainder = b;
        while (a % b != 0)
        {
            remainder = a % b;
            a = b;
            b = remainder;
        }
        return remainder;
    }
}