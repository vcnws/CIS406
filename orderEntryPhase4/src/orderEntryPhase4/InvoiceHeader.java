//Christopher Crawford - CIS406 - Order Entry Phase 4

package orderEntryPhase4;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.System.*;

public class InvoiceHeader {
    private final StringHelper _sh;

    public int Number;
    public Date Date;
    public String Name;
    public String Address;
    public String City;
    public String State;
    public int ZipCode;
    public List<InvoiceLine> Lines = new ArrayList<>();

    public InvoiceHeader(StringHelper sh){
        _sh  = sh;
        this.Number = 100;
        this.Date = new Date();
        this.Name = "";
        this.Address = "";
        this.City = "";
        this.State = "";
        this.ZipCode = 0;
    }

    public void Print(){
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        out.println("\nInvoice No.:    " + this.Number);
        out.println("Invoice Date:   " + df.format(this.Date) + "\n");
        out.println(this.Name);
        out.println(this.Address);
        out.println(this.City + ", " + this.State + " " + this.ZipCode + "\n");

        out.println("Line Detail:");
        var sb = new StringBuilder()
                .append(_sh.PadString("Item No.", 10))
                .append(_sh.PadString("Description", 20))
                .append(_sh.PadString("Qty", 6))
                .append(_sh.PadString("Unit Price", 12))
                .append(_sh.PadString("Gross Amt.", 15))
                .append(_sh.PadString("Tax %", 8))
                .append(_sh.PadString("Tax $", 12))
                .append(_sh.PadString("Disc. %", 8))
                .append(_sh.PadString("Disc. $", 12))
                .append(_sh.PadString("Net Amt.", 15))
                .append("\n");

        double totalGross = 0.0;
        double totalTax = 0.0;
        double totalDisc = 0.0;

        for (InvoiceLine line: Lines){
            totalGross += line.GrossAmount();
            totalTax += line.TaxAmount();
            totalDisc += line.DiscountAmount();
            sb.append(line.ToString());
        }

        sb.append("\n")
                .append(_sh.PadString("Total Gross Amt:", 20))
                .append(_sh.GetCurrency(totalGross)).append("\n")
                .append(_sh.PadString("Total Tax Amt:", 20))
                .append(_sh.GetCurrency(totalTax)).append("\n")
                .append(_sh.PadString("Total Disc Amt:", 20))
                .append(_sh.GetCurrency(totalDisc)).append("\n")
                .append(_sh.PadString("Total Net Amt:", 20))
                .append(_sh.GetCurrency(totalGross + totalTax - totalDisc)).append("\n");

        out.println(sb);
    }
}
