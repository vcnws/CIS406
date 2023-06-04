//Christopher Crawford - CIS406 - Vacation Diary 2

package vacationDiary2;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class InputValidator {
    private final StringHelper _sh;
    private final Scanner _sc;

    public InputValidator(StringHelper sh, Scanner sc){
        _sh = sh;
        _sc = sc;
    }

    public String GetDateString(String input) {
        try{
            //check for integer value
            int dateInteger = Integer.parseInt(input);

            //check for valid length
            if (input.length() < 8)
                throw new Exception();

            String dateString = input.substring(0,2) + "/" + input.substring(2,4) + "/" + input.substring(4, 8);

            //validate proper date format
            Date d = new Date(dateString);
            return dateString;
        } catch (Exception ex){
            return "";
        }
    }

    public int GetDays(){
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

    public String GetMode(){
        String[] allowedValues = {"car","plane","ship","train","bus"};
        while (true){
            System.out.print(_sh.PadString("Enter Mode of Travel (car,plane,ship,train,bus):", 55));
            var mode = _sc.nextLine();

            if (Arrays.stream(allowedValues).anyMatch(s -> s.equalsIgnoreCase(mode)))
                return mode;

            System.out.println("Enter a valid mode of travel.");
        }
    }

    public String GetLimitedString(String prompt){
        System.out.print(_sh.PadString(prompt, 55));
        String input = _sc.nextLine();
        if (input.length() < 15)
            input = _sh.PadString(input, 15);
        if (input.length() > 15)
            input = input.substring(0, 15);
        return input;
    }
}
