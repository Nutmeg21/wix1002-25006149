import java.util.*;
import java.io.*;

public class L10Q3 {
    public static void main(String[] args) {
        ShuffleCipher shuffle = new ShuffleCipher("testShuffleInput", "testShuffleOutput", 4);
        ShuffleCipher unshuffle = new ShuffleCipher("testUnshuffleInput", "testUnshuffleOutput", 4);
        shuffle.encode();
        unshuffle.decode();
    }
}

interface MessageEncoder {
    public void encode();

    public void decode();
}

class ShuffleCipher implements MessageEncoder {
    String inputFileName;
    String outputFileName;
    int N;

    public ShuffleCipher(String inputFileName, String outputFileName, int n)
    {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.N = n;
    }
    
    public void encode()
    {
        try {
            Scanner input = new Scanner(new FileInputStream(inputFileName + ".txt"));
            PrintWriter output = new PrintWriter(new FileOutputStream(outputFileName + ".txt"));

            while (input.hasNextLine()) {
                String line = input.nextLine();
                StringBuilder currentWord = new StringBuilder();

                for (char c : line.toCharArray())
                {
                    if (Character.isLetterOrDigit(c))
                    {
                        currentWord.append(c);
                    }
                    else
                    {
                        if (currentWord.length() > 0) {
                            String word = currentWord.toString();
                            for (int i = 0; i < N; i++)
                            {
                                word = encrypt(word);
                            }
                            output.print(word);
                            currentWord.setLength(0);
                        }
                        // Print the space or punctuation
                        output.print(c);
                    }
                }
                if (currentWord.length() > 0)
                {
                    String word = currentWord.toString();
                    for(int i=0; i<N; i++)
                    {
                        word = encrypt(word);
                    }
                    output.print(word);
                }
                output.println();
            }
            input.close();
            output.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void decode()
    {
        try {
            Scanner input = new Scanner(new FileInputStream(inputFileName + ".txt"));
            PrintWriter output = new PrintWriter(new FileOutputStream(outputFileName + ".txt"));

            while (input.hasNextLine())
            {
                String line = input.nextLine();
                StringBuilder currentWord = new StringBuilder();

                for (char c : line.toCharArray())
                {
                    if (Character.isLetterOrDigit(c))
                    {
                        currentWord.append(c);
                    }
                    else
                    {
                        if (currentWord.length() > 0)
                        {
                            String word = currentWord.toString();
                            for(int i = 0; i < N; i++) {
                                word = decrypt(word);
                            }
                            output.print(word);
                            currentWord.setLength(0);
                        }
                        output.print(c);
                    }
                }
                if (currentWord.length() > 0)
                {
                    String word = currentWord.toString();
                    for(int i=0; i<N; i++)
                    {
                        word = decrypt(word);
                    }
                    output.print(word);
                }
                output.println();
            }
            input.close();
            output.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String encrypt(String text)
    {
        char[] half1 = text.substring(0, text.length() / 2).toCharArray();
        char[] half2 = text.substring(text.length() / 2).toCharArray();
        char[] ch = new char[text.length()];

        for (int i = 0; i < half1.length; i++)
        {
            ch[i * 2] = half1[i];
            ch[(i * 2) + 1] = half2[i];
        }
        if (ch.length % 2 != 0)
        {
            ch[ch.length - 1] = half2[half2.length - 1];
        }

        String result = new String(ch);
        return result;
    }

    private String decrypt(String text)
    {
        int mid = text.length() / 2;

        char[] half1 = new char[mid];
        char[] half2 = new char[text.length() - mid];

        int k1 = 0;
        int k2 = 0;

        for (int i = 0; i < text.length(); i++)
        {
            if (i % 2 == 0 && k1 < mid)
            {
                half1[k1++] = text.charAt(i);
            }
            else
            {
                half2[k2++] = text.charAt(i);
            }
        }

        return new String(half1) + new String(half2);
    }
}