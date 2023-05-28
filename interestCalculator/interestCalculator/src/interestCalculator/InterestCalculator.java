//Christopher Crawford - CIS406 - Interest Calculator

package interestCalculator;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculator {
    static StringHelper sh = new StringHelper();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Welcome to the Interest Calculator\n");

        try{
            var choice = "y";
            while (choice.equalsIgnoreCase("y")){
                System.out.print("Enter loan amount:            ");
                var loanAmount = Double.parseDouble(sc.nextLine());

                System.out.print("Enter interest rate:          ");
                var interestRate = Double.parseDouble(sc.nextLine());

                DisplayOutput(loanAmount, interestRate);

                System.out.print("Continue? (y/n)               ");
                choice = sc.nextLine();
                System.out.println();
            }
            System.out.println("Thanks for playing!");
        } catch(Exception ex){
            System.out.print(ex.getMessage());
        } finally {
            sc.close();
        }
    }

    private static double CalculateInterest(double loanAmount, double interestRate){
        return loanAmount * interestRate / 100;
    }

    private static void DisplayOutput(double loanAmount, double interestRate){
        var sb = new StringBuilder("\n");
        sb.append(sh.PadString("Loan Amount:",20) + sh.GetCurrency(loanAmount) + "\n");
        sb.append(sh.PadString("Interest Rate:",20) + interestRate + "%\n");
        sb.append(sh.PadString("Interest Amount:",20) +
                  sh.GetCurrency(CalculateInterest(loanAmount, interestRate)) + "\n");
        System.out.println(sb);
    }
}
