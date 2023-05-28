//Christopher Crawford - CIS406 - Interest Calculator

package interestCalculator;
import java.text.NumberFormat;

public class StringHelper {
    public String PadString(String input, int length) {
        StringBuilder inputBuilder = new StringBuilder(input);
        while (inputBuilder.length() < length) {
            inputBuilder.append(" ");
        }
        input = inputBuilder.toString();
        return input;
    }

    public String GetCurrency(double input){
        NumberFormat num = NumberFormat.getCurrencyInstance();
        num.setMaximumFractionDigits(2);
        return num.format(input);
    }
}
