//Christopher Crawford - CIS406 - Travel Time Calculator

package travelTimeCalculator;
import java.util.*;

public class TravelTimeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to the Travel Time Calculator\n");

            System.out.print("Enter miles:                ");
            var miles = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Enter miles per hour:       ");
            var mph = Double.parseDouble(scanner.nextLine().trim());

            int totalMinutesTravelled = (int)(miles / mph) * 60;
            int hours = totalMinutesTravelled / 60;
            int minutes = totalMinutesTravelled % 60;

            System.out.println("\nEstimated travel time   ");
            System.out.println("--------------------------");
            System.out.println("Hours:     " + hours);
            System.out.println("Minutes:   " + minutes);
            System.out.print("\nThanks for playing!");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        } finally {
            scanner.close();
        }
    }
}
