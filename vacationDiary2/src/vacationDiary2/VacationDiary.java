//Christopher Crawford - CIS406 - Vacation Diary 2

package vacationDiary2;

import java.util.Scanner;

public class VacationDiary {
    static StringHelper _sh;
    static Scanner _sc;
    static StringBuilder _sb;
    static InputValidator _iv;

    public static void main(String[] args) {
        _sc = new Scanner(System.in);
        _sh = new StringHelper();
        _sb = new StringBuilder();
        _iv = new InputValidator(_sh,_sc);
        boolean linesAdded = false;

        BuildHeader();

        System.out.println("Vacation Diary\n");

        String input = "";
        while (!input.equalsIgnoreCase("end")){

            String dateString = "";
            while (dateString.length() == 0){
                System.out.print(_sh.PadString("Enter Date Vacation Started (mmddyyyy) or End to quit:", 55));
                input = _sc.nextLine();

                if (input.equalsIgnoreCase("end")) break;

                dateString = _iv.GetDateString(input);
                if (dateString.length() <= 0)
                    System.out.println("Invalid date format. Please re-enter.");
            }
            if (input.equalsIgnoreCase("end")) break;

            String city = _iv.GetLimitedString("Enter City Visited:");
            String country = _iv.GetLimitedString("Enter Country Visited:");
            int days = _iv.GetDays();
            String mode = _iv.GetMode();

            AppendLine(new String[]{dateString, city, country, String.valueOf(days), mode});
            linesAdded = true;
            System.out.println();
        }

        _sb.append("==============================================================================\n");
        if (linesAdded)
            System.out.println("\n" + _sb);
        System.out.println("\nThanks for playing!");

        _sc.close();
        _sh = null;
        _iv = null;
    }

    private static void BuildHeader(){
        _sb.append("==============================================================================\n")
                .append("=============================== Vacation Diary ===============================\n");

        AppendLine(new String[]{"Date","City","Country","Days","Mode"});
        AppendLine(new String[]{"==========","==========","============","=====","========"});
    }

    private static void AppendLine(String[] inputs){
        int[] pads = {16,20,20,10,12};
        for(var i = 0; i < inputs.length; i++){
            _sb.append(_sh.PadString(inputs[i], pads[i]));
        }
        _sb.append("\n");
    }
}
