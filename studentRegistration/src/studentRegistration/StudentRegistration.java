//Christopher Crawford - CIS406 - Student Registration Lab
package studentRegistration;

import java.util.*;

public class StudentRegistration {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Student Registration Form\n");
			
			System.out.print("Enter your last name:");
			String lastName = scanner.nextLine().trim();
			
			System.out.print("Enter your first name:");
			String firstName = scanner.nextLine().trim();
			
			System.out.print("Enter your year of birth:");
			String birthYearString = scanner.nextLine().trim();
			int birthYear = Integer.parseInt(birthYearString);
			
			System.out.println();
			System.out.println("Welcome " + firstName + " " + lastName + "!");
			System.out.println("Your temporary password is " + lastName + "*" + birthYear);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
