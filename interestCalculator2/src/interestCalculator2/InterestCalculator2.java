//Christopher Crawford - CIS406 - Interest Calculator 2

package interestCalculator2;
import java.util.Scanner;

public class InterestCalculator2 {
    public static void main(String[] args) {
        Scanner _sc = new Scanner(System.in);
        StringHelper _sh = new StringHelper();
        InputValidator _iv = new InputValidator(_sh, _sc);

        System.out.println("Welcome to the Interest Calculator\n");

        try{
            var choice = "y";
            while (!choice.equalsIgnoreCase("n")){
                double loanAmount = _iv.GetDoubleValue("Enter loan amount:", 30);
                double interestRate = _iv.GetDoubleValue("Enter interest rate:",30) / 100;
                double interestAmount = loanAmount * interestRate;

                String loanAmountString = _sh.GetCurrency(loanAmount);
                String interestAmountString = _sh.GetCurrency(interestAmount);
                String interestRateString = _sh.GetPercent(interestRate);

                System.out.println("\n" + _sh.PadString("Loan amount:",30) + loanAmountString);
                System.out.println(_sh.PadString("Interest rate:",30) + interestRateString);
                System.out.println(_sh.PadString("Interest:", 30) + interestAmountString + "\n");

                System.out.print(_sh.PadString("Continue? (y/n):", 30));
                choice = _sc.nextLine();
                System.out.println();
            }

            System.out.print("Thanks for playing!");

        } catch (Exception ex){
            System.out.print(ex);
        } finally {
            _sc.close();
        }
    }
}
