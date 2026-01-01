import java.util.*;

public class L8Q6 {
    public static void main(String[] args) {
        Stall a = new Stall();
        Stall b = new Stall();
        Stall c = new Stall();
        a.getSold();
        b.getSold();
        c.getSold();
        a.displaySold();
        b.displaySold();
        c.displaySold();
        Stall.totalSold();
    }
}

class Stall {
    String ID;
    int amountSold;
    static int totalSold = 0;
    Scanner sc = new Scanner(System.in);

    public Stall()
    {
        System.out.print("Enter stall ID: ");
        String stallID = sc.nextLine();
        ID = stallID;
        amountSold = 0;
    }

    public void getSold()
    {
        System.out.println("Enter amount sold by stall " + ID + ":");
        int sold = sc.nextInt();
        amountSold += sold;
        totalSold += sold;
    }

    public void displaySold()
    {
        System.out.println("Amount sold by stall " + ID + ": " + amountSold);
    }

    public static void totalSold()
    {
        System.out.println("Total sold: " + totalSold);
    }
}