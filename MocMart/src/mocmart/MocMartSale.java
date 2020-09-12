/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocmart;

/**
 *
 * @author
 */
public class MocMartSale {

    // Properties
    private String firstName;
    private String lastName;
    private int numItemsOnList;
    private int[] itemsPurchased;
    private static int numSales = 0;

    // Constructor Method
    public MocMartSale(String firstName, String lastName, int numItemsOnList, int[] itemsPurchased) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numItemsOnList = numItemsOnList;
        this.itemsPurchased = itemsPurchased;
        numSales++ ;
    } // end of constructor method

    /*
	*******************
	Getters and Setters
	*******************
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumItemsOnList() {
        return numItemsOnList;
    }

    public void setNumItemsOnList(int numItemsOnList) {
        this.numItemsOnList = numItemsOnList;
    }

    public int[] getItemsPurchased() {
        return itemsPurchased;
    }

    public void setItemsPurchased(int[] itemsPurchased) {
        this.itemsPurchased = itemsPurchased;
    }

    public static int getNumSales() {
        return numSales;
    }

    public static void setNumSales(int numSales) {
        MocMartSale.numSales = numSales;
    }
    
//    @Override
//    public String toString() {
//        return String.format("\t| Item %6d | % 20s | $%7.2f | %4d unit(s) |\n", itemNum, itemName, itemPrice, quantity);
//    }

}
