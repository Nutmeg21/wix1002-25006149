public class L6Q2 {
    public static void main(String[] args) {
        int triangle_height = 4;
        int diamond_height = 4;
        
        // Triangle
        System.out.println("Triangle :");
        for (int i = 1; i <= triangle_height; i++)
        {
            multiPrint(triangle_height - i, ' ');
            multiPrint(i * 2 - 1, '#');
            System.out.println();
        }

        System.out.println();
        
        // Diamond
        System.out.println("Diamond :");
        for (int i = 1; i <= diamond_height; i++)
        {
            multiPrint(diamond_height - i, ' ');
            multiPrint(i * 2 - 1, '#');
            System.out.println();
        }
        for (int i = diamond_height - 1; i > 0; i--)
        {
            multiPrint(diamond_height - i, ' ');
            multiPrint(i * 2 - 1, '#');
            System.out.println();
        }
    }

    public static void  multiPrint(int n, char c) {
        for (int i = 0; i < n; i++)
        {
            System.out.print(c);
        }
    }
}