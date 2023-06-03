//Christopher Crawford - CIS406 - Vacation Diary 2

package vacationDiary2;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Predicate;

public class VacationDiary {
    static StringHelper _sh;
    static Scanner _sc;
    static StringBuilder _sb;

    public static void main(String[] args) {
        _sc = new Scanner(System.in);
        _sh = new StringHelper();
        _sb = new StringBuilder();

        BuildHeader();

        System.out.println("Vacation Diary\n");

        String input = "";
        while (!input.equalsIgnoreCase("end")){

            String dateString = "";
            while (dateString.length() == 0){
                System.out.print(_sh.PadString("Enter Date Vacation Started (mmddyyyy) or End to quit:", 55));
                input = _sc.nextLine();

                if (input.equalsIgnoreCase("end")) break;

                dateString = GetDateString(input);
            }
            if (input.equalsIgnoreCase("end")) break;

            String city = GetCity();
            String country = GetCountry();
            int days = GetDays();

            System.out.print(_sh.PadString("Enter Mode of Travel (car,plane,ship,train,bus):", 55));
            String mode = GetMode();

            AppendLine(new String[]{dateString, city, country, String.valueOf(days), mode});
        }

        _sb.append("==============================================================================\n");
        System.out.println("\n" + _sb);
        System.out.println("\nThanks for playing!");
    }

    private static void BuildHeader(){
        _sb.append("==============================================================================\n")
                .append("=============================== Vacation Diary ===============================\n");

        AppendLine(new String[]{"Date","City","Country","Days","Mode"});
        AppendLine(new String[]{"==========","==========","============","=====","========"});
    }

    private static void AppendLine(String[] inputs){
        int[] pads = {16,16,20,13,13};
        for(var i = 0; i < inputs.length; i++){
            _sb.append(_sh.PadString(inputs[i], pads[i]));
        }
        _sb.append("\n");
    }

    private static String GetDateString(String input) {
        try{
            //check for integer value
            int dateInteger = Integer.parseInt(input);

            //check for valid length
            if (input.length() < 8)
                throw new Exception();

            String dateString = input.substring(0,2) + "/" + input.substring(2,2) + "/" + input.substring(4, 4);
            Date d = new Date(dateString);
            return dateString;
        } catch (Exception ex){
            return "";
        }
    }

    private static int GetDays(){
        while (true){
            System.out.print(_sh.PadString("Enter Number of Days Visited:",55));
            try{
                var days = Integer.parseInt(_sc.nextLine());
                if (days < 1 || days > 30)
                    throw new Exception();

                return days;
            } catch (Exception ex){
                System.out.println("Days must be between 1 and 30");
            }
        }
    }

    private static String GetMode(){
        String[] allowedValues = {"car","plane","ship","train","bus"};
        while (true){
            var mode = _sc.nextLine();

            if (Arrays.stream(allowedValues).anyMatch(s -> s.equalsIgnoreCase(mode)))
                return mode;

            System.out.println("Enter a valid mode of travel.");
        }
    }

    private static String GetCity(){
        while (true){
            System.out.print(_sh.PadString("Enter City Visited:", 55));
            String city = _sc.nextLine();
            if (city.length() < 15){
                System.out.println("Enter a valid city.");
                continue;
            }
            return city.substring(0,30);
        }
    }

    private static String GetCountry(){
        while (true){
            System.out.print(_sh.PadString("Enter Country Visited:", 55));
            String country = _sc.nextLine();
            if (country.length() < 15){
                System.out.println("Enter a valid city.");
                continue;
            }
            return country.substring(0,30);
        }
    }
}
