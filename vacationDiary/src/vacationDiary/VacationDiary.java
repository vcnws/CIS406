//Christopher Crawford - CIS406 - Vacation Diary Lab

package vacationDiary;
import java.util.*;

public class VacationDiary {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Enter date vacation started (mm/dd/yyyy): ");
			var startDate = scanner.nextLine().trim();
			
			System.out.print("Enter city visited: ");
			var cityVisited = scanner.nextLine().trim();
			
			System.out.print("Enter country visited: ");
			var countryVisited = scanner.nextLine().trim();
			
			System.out.print("Enter number of days: ");
			var numDays = scanner.nextInt();
			scanner.nextLine();
			
			System.out.print("Enter mode of travel (car, airplane, ship, train, bus): ");
			var travelMode = scanner.nextLine().trim();
			
			System.out.println();
			String br = "\r\n";
			StringBuilder sb = new StringBuilder();
			sb.append("Details of your trip:" + br);
			sb.append("Date: " + startDate + br);
			sb.append("City: " + cityVisited + br);
			sb.append("Country: " + countryVisited + br);
			sb.append("Number of days: " + numDays + br);
			sb.append("Traveled by: " + travelMode + br);
			sb.append("Bye!!!");
			
			System.out.print(sb.toString());
			
			scanner.close();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
