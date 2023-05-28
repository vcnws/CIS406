//Christopher Crawford - CIS406 - Order Entry Phase 3

package orderEntryPhase3;
import java.util.Scanner;

public class OrderEntryPhase3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var cart = new Cart();

        try{
            System.out.println("Order Entry System\n");

            while (true){

                System.out.print("Enter an Item Number or End to Quit:        ");
                var itemNumber = sc.nextLine();

                if (itemNumber.equalsIgnoreCase("end"))
                    break;

                LineItem item = new LineItem(itemNumber);

                System.out.print("Enter an Item Description:                  ");
                item.Description = sc.nextLine();

                System.out.print("Enter the Quantity Ordered:                 ");
                item.Quantity = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter the Unit Price:                       ");
                item.ItemPrice = sc.nextFloat();
                sc.nextLine();

                System.out.print("Enter the Tax Percentage e.g.(0.0825)       ");
                item.TaxPercent = sc.nextFloat();
                sc.nextLine();

                System.out.print("Enter the Discount Percentage e.g.(0.15)    ");
                item.DiscountPercent = sc.nextFloat();
                sc.nextLine();

                cart.LineItems.add(item);

                System.out.println("\nOrder Details");
                System.out.println(item.ToString() + "\n");
            }

            System.out.print("\n" + cart.ToString() + "\n");
            System.out.print("\nThanks for playing!");

        } catch (Exception ex){
            System.out.print(ex.getMessage());
        } finally {
            sc.close();
        }
    }

}
