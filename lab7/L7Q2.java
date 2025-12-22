import java.util.Scanner;
import java.net.URL;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLConnection;
import java.io.FileOutputStream;
import java.io.IOException;

public class L7Q2 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://fsktm.um.edu.my");
            URLConnection cnn = u.openConnection();
            InputStream stream = cnn.getInputStream();
            Scanner in = new Scanner(stream);
            PrintWriter output = new PrintWriter(new FileOutputStream("./lab7/index.htm"));
            while(in.hasNext())
            {
                output.println(in.nextLine());
            }
            in.close();
            output.close();
        }
        catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
        
    }
    
}
