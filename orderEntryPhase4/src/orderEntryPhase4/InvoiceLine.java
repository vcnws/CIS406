//Christopher Crawford - CIS406 - Order Entry Phase 4

package orderEntryPhase4;

public class InvoiceLine {
    private final StringHelper _sh = new StringHelper();

    public String ItemNumber;
    public String Description;
    public int Quantity;
    public double UnitPrice;
    public double TaxPercent;
    public double DiscountPercent;

    public InvoiceLine(String itemNumber){
        ItemNumber = itemNumber;
    }

    public double GrossAmount(){
        return Quantity * UnitPrice;
    }

    public double TaxAmount(){
        return GrossAmount() * TaxPercent;
    }

    public double DiscountAmount(){
        return GrossAmount() * DiscountPercent;
    }

    public double NetAmount(){
        return GrossAmount() + TaxAmount() - DiscountAmount();
    }

    public String ToString(){
        return _sh.PadString(ItemNumber, 10) +
                _sh.PadString(Description, 20) +
                _sh.PadString(String.valueOf(Quantity), 6) +
                _sh.PadString(_sh.GetCurrency(UnitPrice), 12) +
                _sh.PadString(_sh.GetCurrency(GrossAmount()), 15) +
                _sh.PadString(_sh.GetPercent(TaxPercent), 8) +
                _sh.PadString(_sh.GetCurrency(TaxAmount()), 12) +
                _sh.PadString(_sh.GetPercent(DiscountPercent), 8) +
                _sh.PadString(_sh.GetCurrency(DiscountAmount()), 12) +
                _sh.PadString(_sh.GetCurrency(NetAmount()), 15) +
                "\n";
    }
}
