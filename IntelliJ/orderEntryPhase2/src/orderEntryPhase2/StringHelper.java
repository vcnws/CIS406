package orderEntryPhase2;
import java.text.NumberFormat;

public final class StringHelper {
    private static String GetFixedWidthValue(String input, int length) {
        StringBuilder inputBuilder = new StringBuilder(input);
        while (inputBuilder.length() < length) {
            inputBuilder.append(" ");
        }
        input = inputBuilder.toString();
        return input;
    }

    public static void PadStrings(String[] headers, String[] values){
        for(var i = 0; i <= headers.length - 1; i++) {
            var len = (headers[i].length() > values[i].length())
                    ? headers[i].length() + 3
                    : values[i].length() + 3;

            headers[i] = GetFixedWidthValue(headers[i], len);
            values[i] = GetFixedWidthValue(values[i], len);
        }
    }

    public static String GetString(double input){
        NumberFormat num = NumberFormat.getCurrencyInstance();
        num.setMaximumFractionDigits(2);
        return num.format(input);
    }
}
