//Christopher Crawford - CIS406 - Temperature Conversion

package temperatureConversion;
import java.text.NumberFormat;
import java.util.*;

public class TemperatureConversion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Welcome to the Temperature Converter\n");
			
			System.out.print("Enter a temperature in Fahrenheit: ");
			var fahrenheit = Double.parseDouble(scanner.nextLine());
			
			System.out.println("Degrees in Celsius: " + convertToCelsiusString(fahrenheit) + "\n");
			
			System.out.print("Enter a temperature in Celsius: ");
			var celsius = Double.parseDouble(scanner.nextLine());
			
			System.out.println("Degrees in Celsius: " + convertToFahrenheitString(celsius) + "\n");
			
			System.out.println("Thanks for playing!!");
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			scanner.close();
		}

	}
	
	private static String convertToFahrenheitString(double input) {
		return ConvertDoubleToString((input * 9/5) + 32);
	}
	
	private static String convertToCelsiusString(double input) {
		return ConvertDoubleToString((input - 32) * 5 / 9);
	}
	
	private static String ConvertDoubleToString(double input) {
		NumberFormat num = NumberFormat.getInstance();
		num.setMaximumFractionDigits(2);
		return num.format(input);
	}
}
