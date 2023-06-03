//Christopher Crawford - CIS406 - Order Entry Phase 4

package orderEntryPhase4;
import java.util.Scanner;
import static java.lang.System.*;

public class InputValidator {
    private final StringHelper _sh;
    private final Scanner _sc;

    public InputValidator(StringHelper sh, Scanner sc){
        _sh = sh;
        _sc = sc;
    }

    public double GetDoubleValue(String prompt, int pad){
        while (true){
            out.print(_sh.PadString(prompt, pad));
            try{
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
