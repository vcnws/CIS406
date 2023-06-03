//Christopher Crawford - CIS406 - Interest Calculator 2

package interestCalculator2;

import java.util.Scanner;
import static java.lang.System.out;

public class InputValidator {
    final StringHelper _sh;
    final Scanner _sc;

    public InputValidator(StringHelper sh, Scanner sc) {
        _sh = sh;
        _sc = sc;
    }

    public double GetDoubleValue(String prompt, int pad){
        while (true){
            out.print(_sh.PadString(prompt, pad));
            try{
                return Double.parseDouble(_sc.nextLine());
            } catch (Exception ex){
                out.println("Error! Invalid numeric value.  Try again.");
            }
        }
    }
}