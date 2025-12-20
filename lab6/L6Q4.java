public class L6Q4 {
    public static void main(String[] args) {
        System.out.println(gcd(24, 3));
        System.out.println(gcd(200, 625));
    }

    public static int gcd(int a, int b)
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