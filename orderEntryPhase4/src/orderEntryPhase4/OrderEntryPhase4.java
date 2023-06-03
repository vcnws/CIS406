//Christopher Crawford - CIS406 - Order Entry Phase 4

package orderEntryPhase4;
import java.util.Date;
import java.util.Scanner;

public class OrderEntryPhase4 {
    static Scanner sc = new Scanner(System.in);
    static StringHelper sh = new StringHelper();
    static InputValidator iv = new InputValidator(sh, sc);

    public static void main(String[] args) {
        try {
            System.out.println("Invoice Entry\n");

            var header = GetInvoiceHeader();

            var choice = "y";
            while (choice.equalsIgnoreCase("y")){
                System.out.println();

                header.Lines.add(GetInvoiceLine());

                System.out.print("\n" + sh.PadString("Add another item? (y/n)", 50));
                choice = sc.nextLine();
            }

            System.out.println("==============================================================================");

            header.Print();

            System.out.println("==============================================================================");

            System.out.println();
            System.out.println("Thanks for playing!");

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            sc.close();
            sh = null;
        }
    }

    private static InvoiceLine GetInvoiceLine(){
        int pad = 50;
        System.out.print(sh.PadString("Enter item number:", pad));
        var itemNumber = sc.nextLine();

        var line = new InvoiceLine(itemNumber);

        System.out.print(sh.PadString("Enter item description:", pad));
        line.Description = (sc.nextLine());

        line.Quantity = (iv.GetIntValue("Enter quantity ordered:", pad));
        line.UnitPrice = (iv.GetDoubleValue("Enter unit price:", pad));
        line.TaxPercent = (iv.GetDoubleValue("Enter tax percent (e.g. 8.25):", pad) / 100);
        line.DiscountPercent = (iv.GetDoubleValue("Enter discount percent (e.g. 10):", pad) / 100);

        return line;
    }

    private static InvoiceHeader GetInvoiceHeader(){
        int pad = 50;
        var header = new InvoiceHeader(sh);

        while (true){
            System.out.print(sh.PadString("Enter invoice date: (MM/dd/yyyy)", pad));
            try{
                header.Date = new Date(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("Invalid entry");
            }
        }

        header.Name = iv.GetStringValue("Enter customer name:", pad);
        header.Address = iv.GetStringValue("Enter address:", pad);
        header.City = iv.GetStringValue("Enter city:", pad);
        header.State = iv.GetStringValue("Enter state: (e.g. TX)", pad);
        header.ZipCode = iv.GetIntValue("Enter zipcode:", pad);

        return header;
    }
}
