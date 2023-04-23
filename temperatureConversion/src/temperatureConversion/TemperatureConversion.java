//Christopher Crawford - CIS406 - Temperature Conversion

package temperatureConversion;
import java.util.*;

public class TemperatureConversion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Welcome to the Temperature Converter\n");
			
			System.out.print("Enter a temperature in Fahrenheit: ");
			var fahrenheit = scanner.nextInt();
			
			System.out.println(String.format("Degrees in Celsius: %1d\n", GetCelsius(fahrenheit)));
			
			System.out.print("Enter a temperature in Celsius: ");
			var celsius = scanner.nextInt();
			
			System.out.println(String.format("Degrees in Celsius: %1d\n", GetFahrenheit(celsius)));
			
			System.out.println("Thanks for playing!!");
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			scanner.close();
		}

	}
	
	private static int GetFahrenheit(int input) {
		return Math.round(input * (9/5)) + 32;
	}
	
	private static int GetCelsius(int input) {
		return (input - 32) * Math.round(5/9);
	}
}
