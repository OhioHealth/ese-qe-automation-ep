package dbchangefield;

import java.sql.Timestamp;
import java.util.Date;

public class DbChangefield {
    // Function to convert database time to system clock time
    public static Timestamp convertDBTimeToSystemTime(Timestamp dbTime) {
        // Get the system clock time
        Date systemTime = new Date();

        // Calculate the time difference between system clock time and database time
        long timeDifference = systemTime.getTime() - dbTime.getTime();

        // Add the time difference to the database time to get system clock time
        Timestamp systemClockTime = new Timestamp(dbTime.getTime() + timeDifference);

        return systemClockTime;
    }

    // Example usage
    public static void main(String[] args) {
        // Assume dbTime is retrieved from the database
        Timestamp dbTime = Timestamp.valueOf("2024-04-08 12:30:00");

        // Convert database time to system clock time
        Timestamp systemClockTime = convertDBTimeToSystemTime(dbTime);

        System.out.println("Database time: " + dbTime);
        System.out.println("System clock time: " + systemClockTime);
    }
}
