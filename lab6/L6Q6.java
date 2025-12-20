public class L6Q6 {
    public static void main(String[] args) {
        int p_cnt = 0, e_cnt = 0, num = 2;
        int[] p_arr = new int[20];
        int[] e_arr = new int[20];
        while (p_cnt < 20 || e_cnt < 20)
        {
            if ((palindromic_prime_or_emirp(num)).equals("palindromic") && p_cnt < 20)
            {
                p_arr[p_cnt] = num;
                p_cnt++;
            }
            else if ((palindromic_prime_or_emirp(num)).equals("emirp") && e_cnt < 20)
            {
                e_arr[e_cnt] = num;
                e_cnt++;
            }
            num++;
        }

        System.out.println("Palindromic primes: ");
        System.out.print("[");
        for (int i = 0; i < p_arr.length; i++)
        {
            System.out.print(p_arr[i]);
            if (i != p_arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.println("Emirps: ");
        System.out.print("[");
        for (int i = 0; i < e_arr.length; i++)
        {
            System.out.print(e_arr[i]);
            if (i != e_arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static String palindromic_prime_or_emirp(int num) {
        boolean prime = prime(num);
        int reverse = reverse(num);
        boolean reversed_prime = prime(reverse);
        if (prime & reversed_prime)
        {
            if (num == reverse)
                return "palindromic";
            else
                return "emirp";
        }
        return " ";
    }

    public static int reverse(int num)
    {
        int reverse = 0;
        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit; 
            num /= 10;
        }
        return reverse;
    }

    public static boolean prime(int num)
    {
        for (int i = 2; i < Math.sqrt(num); i++)
        {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}