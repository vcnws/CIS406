//Christopher Crawford - CIS406 - Grade Converter
package orderEntryPhase3;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public Cart(){
        LineItems = new ArrayList<LineItem>();
    }

    public List<LineItem> LineItems;

    public float GrossAmount(){
        float _gross = 0;
        for (LineItem lineItem : this.LineItems) _gross += lineItem.GrossAmount();
        return _gross;
    }

    public float TaxAmount(){
        float _tax = 0;
        for (LineItem lineItem : this.LineItems) _tax += lineItem.TaxAmount();
        return _tax;
    }

    public float DiscountAmount() {
        float _discount = 0;
        for (LineItem lineItem : this.LineItems) _discount += lineItem.DiscountAmount();
        return _discount;
    }

    public float NetAmout(){
        float _net = 0;
        for (LineItem lineItem : this.LineItems) _net += lineItem.NetAmount();
        return _net;
    }

    public String ToString(){
        var sh = new StringHelper();
        var sb = new StringBuilder();
        sb.append("Order Totals\n")
                .append("Total Items Purchased:    " + this.LineItems.stream().count() + "\n")
                .append("Total Gross Amt:          " + sh.GetCurrency(this.GrossAmount()) + "\n")
                .append("Total Tax Amt:            " + sh.GetCurrency(this.TaxAmount()) + "\n")
                .append("Total Discount Amt:       " + sh.GetCurrency(this.DiscountAmount()) + "\n")
                .append("Total Net Amt:            " + sh.GetCurrency(this.NetAmout()));

        return sb.toString();
    }
}
