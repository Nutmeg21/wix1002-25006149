public class L6Q1 {
    public static void main(String[] args) {
        int num = 20;
        for (int i = 1; i <= num; i++)
        {
            System.out.println(getTriangle(i));
        }
    }

    public static int getTriangle(int num)
    {
        int triangle = 0;
        for (int i = 0; i <= num; i++)
        {
            triangle += i;
        }
        return triangle;
    }
}