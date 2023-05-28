//Christopher Crawford - CIS406 - Order Entry Phase 3

package orderEntryPhase3;

public class LineItem {
    public String ItemNumber;
    public String Description;
    public int Quantity;
    public float ItemPrice;
    public float TaxPercent;
    public float DiscountPercent;

    public LineItem(String itemNumber){
        this.ItemNumber = itemNumber;
    }

    public float GrossAmount(){
        return this.Quantity * this.ItemPrice;
    }

    public float TaxAmount(){
        return this.GrossAmount() * this.TaxPercent;
    }

    public float DiscountAmount() {
        return this.GrossAmount() * this.DiscountPercent;
    }

    public float NetAmount(){
        return this.GrossAmount() + this.TaxAmount() - this.DiscountAmount();
    }

    public String ToString(){
        var sh = new StringHelper();
        var sb = new StringBuilder();
        sb.append(sh.PadString("Item", 15))
                .append(sh.PadString("Desc", 25))
                .append(sh.PadString("Price", 12))
                .append(sh.PadString("Qty", 8))
                .append(sh.PadString("Gross", 12))
                .append(sh.PadString("Tax", 12))
                .append(sh.PadString("Disc",12))
                .append(sh.PadString("Net Amount", 0))
                .append("\n");

        sb.append(sh.PadString(this.ItemNumber, 15))
                .append(sh.PadString(this.Description, 25))
                .append(sh.PadString(sh.GetCurrency(this.ItemPrice), 12))
                .append(sh.PadString(String.valueOf(this.Quantity), 8))
                .append(sh.PadString(sh.GetCurrency(this.GrossAmount()), 12))
                .append(sh.PadString(sh.GetCurrency(this.TaxAmount()), 12))
                .append(sh.PadString(sh.GetCurrency(this.DiscountAmount()),12))
                .append(sh.PadString(sh.GetCurrency(this.NetAmount()), 0));

        return sb.toString();
    }
}