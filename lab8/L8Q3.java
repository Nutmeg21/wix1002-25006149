import java.util.*;

public class L8Q3 {
    public static void main(String[] args) {
        WeightCalculator w = new WeightCalculator();
        w.weight();
    }
}

class WeightCalculator {
    int age;
    double height;

    public WeightCalculator()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int userAge = sc.nextInt();
        System.out.print("Enter height(in cm): ");
        double userHeight = sc.nextDouble();
        age = userAge;
        height = userHeight;
    }

    public void weight()
    {
        System.out.printf("Recommended weight: %.2f kg \n", ((height - 100 + age / 10) * 0.9));
    }
}
