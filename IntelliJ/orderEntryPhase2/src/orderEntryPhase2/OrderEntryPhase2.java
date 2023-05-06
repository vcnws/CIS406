//Christopher Crawford - CIS406 - Course Project Phase 2
package orderEntryPhase2;
import java.util.*;

public class OrderEntryPhase2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Order Entry System\n");

            System.out.print("Enter an item number:                   ");
            var itemNumber = scanner.nextLine().trim();

            System.out.print("Enter an item description:              ");
            var itemDesc = scanner.nextLine().trim();

            System.out.print("Enter the item price:                   ");
            double itemPrice = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter a quantity ordered:               ");
            int quantity = Integer.parseInt(scanner.nextLine());

            double grossAmt = itemPrice * quantity;

            System.out.print("Enter the tax percentage:               ");
            double tax = Double.parseDouble(scanner.nextLine());

            double lineTax = grossAmt * (tax / 100);

            System.out.print("Enter the discount percentage:          ");
            double discount = Double.parseDouble(scanner.nextLine());

            double lineDiscount = grossAmt * (discount / 100);

            double netAmt = grossAmt + lineTax - lineDiscount;

            System.out.println("\nOrder Details");

            var headers = new String[] {"Item No.","Description","Price","Qty", "Gross Amt", "Tax Amt","Disc Amt","Net Amt"};

            var values = new String[] {itemNumber, itemDesc, StringHelper.GetString(itemPrice),
                    String.valueOf(quantity), StringHelper.GetString(grossAmt), StringHelper.GetString(lineTax),
                    "-" + StringHelper.GetString(lineDiscount), StringHelper.GetString(netAmt)};

            StringHelper.PadStrings(headers, values);

            System.out.println(String.join("", headers));
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println(String.join("",  values));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}
