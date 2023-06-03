//Christopher Crawford - CIS406 - Vacation Diary 2

package vacationDiary2;

import java.util.Scanner;

import static java.lang.System.out;

public class InputValidator {
    private final StringHelper _sh;
    private final Scanner _sc;

    public InputValidator(StringHelper sh, Scanner sc){
        _sh = sh;
        _sc = sc;
    }

    public double GetDoubleValue(String prompt, int pad, double min, double max){
        while (true){
            out.print(_sh.PadString(prompt, pad));
            try{
                var dbl = Double.parseDouble(_sc.nextLine());
                if (dbl < min || dbl > max)
                    throw new Exception("Outside range.");
                return Double.parseDouble(_sc.nextLine());
            } catch (Exception ex){
                out.println("Invalid entry");
            }
        }
    }

    public int GetIntValue(String prompt, int pad){
        while (true){
            out.print(_sh.PadString(prompt, pad));
            try{
                return Integer.parseInt(_sc.nextLine());
            } catch (Exception ex){
                out.println("Invalid entry");
            }
        }
    }

    public String GetStringValue(String prompt, int pad){
        while (true){
            out.print(_sh.PadString(prompt, pad));
            try{
                var val = _sc.nextLine();
                if (val.length() == 0)
                    throw new Exception("Invalid entry");
                return val;
            } catch (Exception ex){
                out.println("Invalid entry");
            }
        }
    }
}
