import java.util.*;

public class L8Q7 {
    public static void main(String[] args) {
        Money a = new Money();
        a.totalCount();
        a.add();
        a.substract();
        a.totalCount();
    }
}

class Money {
    double amount;
    Scanner sc = new Scanner(System.in);

    public Money()
    {
        System.out.println("Enter amount (RM) :");
        amount = sc.nextDouble();
    }

    public void add()
    {
        System.out.println("Enter amount to add (RM) :");
        amount += sc.nextDouble();
    }

    public void substract()
    {
        System.out.println("Enter amount to substract (RM) :");
        amount -= sc.nextDouble();
    }

    public void totalCount()
    {
        amount = round(amount);
        int ringgit = (int) Math.floor(amount);
        double sen = (int) ((amount - ringgit) * 100);
        int[] notes = {100, 50, 20, 10, 5, 1};
        int[] coins = {50, 20, 10, 5};

        int totalNotes = 0, totalCoins = 0;

        for (int note : notes)
        {
            if (ringgit >= note)
            {
                totalNotes += ringgit / note;
                ringgit %= note;
            }
        }

        for (int coin : coins)
        {
            if (sen >= coin)
            {
                totalCoins += sen / coin;
                sen %= coin;
            }
        }

        System.out.println("Total notes needed: " + totalNotes);
        System.out.println("Total coins needed: " + totalCoins);
    }

    public double round(double value)
    {
        int ringgit = (int) Math.floor(value);
        double sen = value - ringgit;

        if (sen == 0.0) {
            return value; 
        }

        int lastDigit = (int) Math.round(value * 100) % 10;
        double base = Math.floor(value * 10) / 10.0; 

        if (lastDigit == 1 || lastDigit == 2)
            return base;
        if (lastDigit == 3 || lastDigit == 4 || lastDigit == 6 || lastDigit == 7)
            return base + 0.05;
        if (lastDigit == 8 || lastDigit == 9)
            return base + 0.10;
        
        return value;
    }
}
