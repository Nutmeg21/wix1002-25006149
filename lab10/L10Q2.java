import java.util.*;
import java.io.*;

public class L10Q2 {
    public static void main(String[] args) {
        SubstitutionCipher encodeTest = new SubstitutionCipher("testEncodeInput", "testEncodeOutput", 10);
        SubstitutionCipher decodeTest = new SubstitutionCipher("testDecodeInput", "testDecodeOutput", 21);
        encodeTest.encode();
        decodeTest.decode();
    }
}

interface MessageEncoder {
    public void encode();

    public void decode();
}

class SubstitutionCipher implements MessageEncoder {
    String inputFileName;
    String outputFileName;
    int shift;

    public SubstitutionCipher(String inputFileName, String outputFileName, int shift)
    {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.shift = shift;
    }
    
    public void encode()
    {
        try {
            Scanner input = new Scanner(new FileInputStream(inputFileName + ".txt"));
            PrintWriter output = new PrintWriter(new FileOutputStream(outputFileName + ".txt"));
            while (input.hasNext())
            {
                String plainText = input.nextLine();
                String cipherText = encrypt(plainText, shift);
                output.println(cipherText);
            }
            input.close();
            output.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void decode()
    {
        shift = 26 - (shift % 26);
        try {
            Scanner input = new Scanner(new FileInputStream(inputFileName + ".txt"));
            PrintWriter output = new PrintWriter(new FileOutputStream(outputFileName + ".txt"));
            while (input.hasNext())
            {
                String cipherText = input.nextLine();
                String plainText = encrypt(cipherText, shift);
                output.println(plainText);
            }
            input.close();
            output.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String encrypt(String text, int shift)
    {
        shift = shift % 26;        
        char[] chars = text.toCharArray();
        
        for (int i = 0; i < chars.length; i++)
        {
            if (Character.isUpperCase(chars[i]))
            {
                char shiftedChar = (char)(((int)chars[i] + shift - 'A') % 26 + 'A');
                chars[i] = shiftedChar;
            }
            else if (Character.isLowerCase(chars[i]))
            {
                char shiftedChar = (char)(((int)chars[i] + shift - 'a') % 26 + 'a');
                chars[i] = shiftedChar;
            }
        }

        String result = new String(chars);
        return result;
    }
}