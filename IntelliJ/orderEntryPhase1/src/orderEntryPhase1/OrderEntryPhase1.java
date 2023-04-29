//Christopher Crawford - CIS406 - Course Project Phase 1
package orderEntryPhase1;
import java.util.*;

public class OrderEntryPhase1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Order Entry System\n");

            System.out.print("Enter an item number: ");
            var itemNumber = scanner.nextLine().trim();

            System.out.print("Enter an item description: ");
            var itemDesc = scanner.nextLine().trim();

            System.out.print("Enter the item price: ");
            float itemPrice = scanner.nextFloat();

            System.out.print("Enter a quantity ordered: ");
            int quantity = scanner.nextInt();

            System.out.print("Enter the total tax for the item: ");
            float tax = scanner.nextFloat();

            System.out.print("Enter the total discount for the item: ");
            float discount = scanner.nextFloat();

            System.out.print("Enter the net amount for the item: ");
            float netAmt = scanner.nextFloat();

            System.out.println("\nOrder Details");
            var headers = new String[] {"Item No.","Description","Price","Qty","Tax","Discount","Net Amount"};
            var values = new String[] {itemNumber, itemDesc, String.valueOf(itemPrice), String.valueOf(quantity),
                    String.valueOf(tax), String.valueOf(discount),String.valueOf(netAmt)};

            PadStrings(headers, values);
            System.out.println(String.join("", headers));
            System.out.println(String.join("",  values));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String GetFixedWidthValue(String input, int length) {
        StringBuilder inputBuilder = new StringBuilder(input);
        while (inputBuilder.length() < length) {
            inputBuilder.append(" ");
        }
        input = inputBuilder.toString();
        return input;
    }

    private static void PadStrings(String[] headers, String[] values){
        for(var i = 0; i <= headers.length - 1; i++) {
            var len = (headers[i].length() > values[i].length())
                    ? headers[i].length() + 3
                    : values[i].length() + 3;

            headers[i] = GetFixedWidthValue(headers[i], len);
            values[i] = GetFixedWidthValue(values[i], len);
        }
    }
}
