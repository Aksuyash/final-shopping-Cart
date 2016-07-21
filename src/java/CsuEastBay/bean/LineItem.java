/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CsuEastBay.bean;

import CsuEastBay.Util.Product;
import CsuEastBay.model.Item;
import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author welcome
 */
public class LineItem implements Serializable {

    private Product item;
    private int quantity;

    public LineItem() {}

    public void setProduct(Product p) {
        item = p;
    }

    public Product getProduct() {
        return item;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        double total = item.getValue() * quantity;
        return total;
    }

    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}


