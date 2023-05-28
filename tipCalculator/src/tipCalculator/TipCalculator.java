//Christopher Crawford - CIS406 - Tip Calculator

package tipCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Tip Calculator\n");

            var choice = "y";
            while (choice.equalsIgnoreCase("y")){
                System.out.print("Enter meal amount:                  ");
                var mealAmount = Double.parseDouble(sc.nextLine());

                DisplayTipAmounts(mealAmount);

                System.out.print("Continue: (y/n)                   ");
                choice = sc.nextLine();
                System.out.println();
            }

            System.out.println("Thanks for playing!\n");
        } catch (Exception ex){
            System.out.print(ex.getMessage());
        } finally {
            sc.close();
        }
    }

    private static void DisplayTipAmounts(double mealAmount){
        StringHelper sh = new StringHelper();
        double[] tips = {.15,.20,.25};
        int[] colPads = {10,10,15};

        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(3);

        StringBuilder sb = new StringBuilder("\n");
        sb.append(sh.PadString("Tip %", colPads[0]));
        sb.append(sh.PadString("Tip $", colPads[1]));
        sb.append(sh.PadString("Total $", colPads[2]) + "\n");
        sb.append("===================================\n");

        for (var i = 0; i < tips.length; i++){
            var tipPercent = tips[i];
            var tipAmt = mealAmount * tipPercent;
            var totalAmt = tipAmt + mealAmount;

            sb.append(sh.PadString(percent.format(tipPercent), colPads[0]));
            sb.append(sh.PadString(sh.GetCurrency(tipAmt), colPads[1]));
            sb.append(sh.PadString(sh.GetCurrency(totalAmt), colPads[2]) + "\n");
        }
        System.out.println(sb);
    }
}
