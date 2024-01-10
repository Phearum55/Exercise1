import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

 class ShortDateToFullDateConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a short date
        System.out.print("Enter a short date (YYYY-MM-DD): ");
        String shortDate = scanner.nextLine();

        // Validate the input format
        if (isValidShortDate(shortDate)) {
            // Extract year, month, and day
            int year = Integer.parseInt(shortDate.substring(0, 4));
            int month = Integer.parseInt(shortDate.substring(5, 7));
            int day = Integer.parseInt(shortDate.substring(8, 10));

            // Convert month number to month name
            String monthName = getMonthName(month);

            // Display the full date representation
            System.out.println("Full Date: " + monthName + " " + day + ", " + year);
        } else {
            System.out.println("Invalid short date format. Please use YYYY-MM-DD.");
        }

        scanner.close();
    }

    // Method to check the validity of the short date format
    private static boolean isValidShortDate(String shortDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try {
            // Parse the date, and if successful, it's a valid date
            Date date = dateFormat.parse(shortDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // Method to convert month number to month name
    private static String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        return monthNames[month - 1];
    }
}