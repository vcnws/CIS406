//Christopher Crawford - CIS406 - Vacation Diary 2

package vacationDiary2;
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

    public String GetPercent(double input){
        NumberFormat pf = NumberFormat.getPercentInstance();
        pf.setMaximumFractionDigits(2);
        return pf.format(input);
    }
}
