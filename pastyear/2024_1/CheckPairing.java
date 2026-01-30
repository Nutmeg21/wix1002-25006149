import java.util.*;
import java.io.*;

public class CheckPairing {
    public static void main(String[] args)
    {
        String[][] participant = new String[4][4];
        ArrayList<String> address = new ArrayList<String>();

        try {
            Scanner input = new Scanner(new FileInputStream("participants.txt"));
            int i = 0;
            while (input.hasNext())
            {
                participant[i][0] = input.nextLine();
                participant[i][1] = input.nextLine();
                participant[i][2] = input.nextLine();
                participant[i][3] = input.nextLine();
                i++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        for (int i = 0; i < 4; i++)
        {
            System.out.println(participant[i][0] + "\t" + participant[i][1] + "\t" + participant[i][2] + "\t" + participant[i][3]);
            participant[i][3] = participant[i][3].replace(" ", "").toLowerCase();
            address.add(participant[i][3]);
        }
        
        if (!checkPairs(address))
        {
            System.out.println("Participants are not in pairs, cannot proceed");
        }
        else 
        {
            int a = -1, b = -1, c = -1, d = -1;
            loop:
            for (int i = 0; i < 3; i++)
            {
                for (int j = i + 1; j < 4; j++)
                {
                    if (address.get(i).equals(address.get(j)))
                    {
                        a = i;
                        c = j;
                        break loop;
                    }
                }
            }
            for (int i = 0; i < 4; i++)
            {
                if (i != a && i != c)
                {
                    if (b == -1)
                        b = i;
                    else
                        d = i;
                }
            }

            try {
                PrintWriter output = new PrintWriter(new FileOutputStream("grouping.txt"));
                output.println("Seat A : " + participant[a][0] + ", " + participant[a][2] + " years old");
                output.println("Seat B : " + participant[b][0] + ", " + participant[b][2] + " years old");
                output.println("Seat C : " + participant[c][0] + ", " + participant[c][2] + " years old");
                output.println("Seat D : " + participant[d][0] + ", " + participant[d][2] + " years old");
                output.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }

    public static boolean checkPairs(ArrayList<String> address)
    {
        ArrayList<String> temp = new ArrayList<>(address);
        if (temp.size() == 0)
            return true;
        for (int i = 0; i < temp.size() - 1; i++)
        {
            for (int j = i + 1; j < temp.size(); j++)
            {
                if (temp.get(i).equals(temp.get(j)))
                {
                    temp.remove(j);
                    temp.remove(i);
                    return checkPairs(temp);
                }
            }
        }
        return false;
    }
}