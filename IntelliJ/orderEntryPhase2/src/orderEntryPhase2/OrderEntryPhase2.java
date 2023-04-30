//Christopher Crawford - CIS406 - Course Project Phase 1
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

            double lineSubtotal = itemPrice * quantity;

            System.out.print("Enter the total tax for the item:       ");
            double tax = Double.parseDouble(scanner.nextLine());

            double lineTax = lineSubtotal * (tax / 100);

            System.out.print("Enter the total discount for the item:  ");
            double discount = Double.parseDouble(scanner.nextLine());

            double netAmt = lineSubtotal + lineTax - discount;

            System.out.println("\nOrder Details");
            var headers = new String[] {"Item No.","Description","Price","Qty","Tax","Discount","Net Amount"};
            var values = new String[] {itemNumber, itemDesc, StringHelper.GetString(itemPrice),
                    String.valueOf(quantity), tax + "%", StringHelper.GetString(discount),StringHelper.GetString(netAmt)};

            StringHelper.PadStrings(headers, values);

            System.out.println(String.join("", headers));
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println(String.join("",  values));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}
