import java.util.*;
import java.io.*;
import java.time.*;

public class L10Q4 {
    public static void main(String[] args) {
        Appointment test1 = new Appointment(21, 6, 2006, 10, 12);
        Appointment test2 = new Appointment(28, 10, 2006, 13, 14);
        test1.saveTo("appointments");
        test2.saveTo("appointments");
    }
}

interface Searchable {
    public boolean search(LocalDateTime dateStartTime, LocalDateTime dateEndTime);
}

class Appointment implements Searchable {
    int day;
    int month;
    int year;
    int startTime;
    int endTime;
    LocalDateTime dateStart;
    LocalDateTime dateEnd;
    String fileOutputName;

    public Appointment(int day, int month, int year, int startTime, int endTime)
    {
        this.day = day;
        this.month = month;
        this.year = year;
        this.startTime = startTime;
        this.endTime = endTime;
        dateStart = LocalDateTime.of(year, month, day, startTime, 0);
        dateEnd = LocalDateTime.of(year, month, day, endTime, 0);
    }

    public void saveTo(String fileName)
    {
        fileOutputName = fileName;
        try {
            PrintWriter output = new PrintWriter(new FileOutputStream(fileOutputName + ".txt", true));
            if (!search(dateStart, dateEnd))
            {
                output.println(day + "/" + month + "/" + year + "," + startTime + "," + endTime);
            }
            else
            {
                System.out.println("Cannot make appointment for +" + dateStart + ". Time not available.");
            }
            output.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean search(LocalDateTime dateStartTime, LocalDateTime dateEndTime)
    {
        try {
            Scanner input = new Scanner(new FileInputStream(fileOutputName + ".txt"));
            while (input.hasNext())
            {
                String[] appointment = input.nextLine().split(",");
                String[] date = appointment[0].split("/");
                int appointmentStartTime = Integer.parseInt(appointment[1]);
                int appointmentEndTime = Integer.parseInt(appointment[2]);
                int day = Integer.parseInt(date[0]);
                int month = Integer.parseInt(date[1]);
                int year = Integer.parseInt(date[2]);

                LocalDateTime appointmentStart = LocalDateTime.of(year, month, day, appointmentStartTime, 0);
                LocalDateTime appointmentEnd = LocalDateTime.of(year, month, day, appointmentEndTime, 0);

                if (dateStartTime.isBefore(appointmentEnd) && dateEndTime.isAfter(appointmentStart))
                {
                    input.close();
                    return true;
                }
            }
            input.close();
            return false;
        } catch (Exception e) {
            System.out.println();
        }
        return false;
    }
}