package mocmart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author
 */
public class MocMartProduct {

    // Properties
    private int itemNum;
    private String itemName;
    private double itemPrice;
    private int quantity;
    private int restockQuantity;
    private static int numProducts=0;
    private  int unitsSold = 0 ;

    // Constructor method
    public MocMartProduct(int itemNum, String itemName, double itemPrice, int quantity, int restockQuantity) {
        this.itemNum = itemNum;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.restockQuantity = restockQuantity;
        this.unitsSold =0 ;
        numProducts++ ;
    } // end constructor

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRestockQuantity() {
        return restockQuantity;
    }

    public void setRestockQuantity(int restockQuantity) {
        this.restockQuantity = restockQuantity;
    }

    public static int getNumProducts() {
        return numProducts;
    }

    public static void setNumProducts(int numProducts) {
        MocMartProduct.numProducts = numProducts;
    }
    
    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    @Override
    public String toString() {
        return String.format("\t| Item %6d | %20s | $%7.2f | %4d unit(s) |\n", itemNum, itemName, itemPrice, quantity);
        //return "\t"+itemNum+", "+itemName+", "+itemPrice+", "+quantity+"\n";
    }
}
