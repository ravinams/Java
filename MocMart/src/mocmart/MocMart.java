package mocmart;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author oracle
 */
public class MocMart {

    /**
     * @param args the command line arguments
     *
     */
    private static int getUnitsSold(MocMartSale[] sales, int itemNum)
    {
        int soldCnt = 0;
        for (int i = 0; i < MocMartSale.getNumSales(); i++) {
            int[] itemsPurchased = sales[i].getItemsPurchased() ;
            for(int j = 0 ; i < itemsPurchased.length ; j+=2)
            {
                if (itemsPurchased[i]== itemNum)
                    soldCnt = soldCnt + itemsPurchased[i+1] ;
            }
        }
        return soldCnt ;
    }            
    private static MocMartProduct findProduct(MocMartProduct[] prods, int itemNum) {
        MocMartProduct prod = null;
        for (int i = 0; i < MocMartProduct.getNumProducts(); i++) {
            if (prods[i].getItemNum() == itemNum) {
                prod = prods[i];
                break;
            }
        }
        return prod;
    }

    private static MocMartProduct binarySearch(MocMartProduct[] prods, int key, int low, int high,PrintWriter outputFile) {

        if (high >= low) {

            int mid = (low + high) / 2;
            outputFile.write(" " + mid + " ");
            if (prods[mid].getItemNum() == key) {
                return prods[mid];
            }
            if (prods[mid].getItemNum() < key) {
                return binarySearch(prods, key, mid + 1, high,outputFile);
            } else {
                return binarySearch(prods, key, low, mid - 1,outputFile);
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        int maxProducts = 0, maxSales = 0;

        MocMartProduct[] products = null;
        MocMartSale[] sales = null;

        try {
            Scanner inputFile = new Scanner(new FileInputStream("MocMart.in"));
            PrintWriter outputFile = new PrintWriter(new FileWriter("MocMart.out"));

            if (inputFile.hasNextLine()) {
                maxProducts = Integer.valueOf(inputFile.nextLine());
            }
            if (inputFile.hasNextLine()) {
                maxSales = Integer.valueOf(inputFile.nextLine());
            }

            products = new MocMartProduct[maxProducts];
            sales = new MocMartSale[maxSales];

            //System.out.println("maxProducts =" + maxProducts);
            // System.out.println("maxSales =" + maxSales);
            
            while (inputFile.hasNextLine()) {
                
                String line = inputFile.nextLine();
                String lineItems[] = line.split(" ");
                String command = lineItems[0];
               // System.out.println(command + ":");
                outputFile.write(command + ":\n");
                
                if (null != command) {
                    
                    switch (command) {
                        
                        case "INVENTORY":
                            
                            if (MocMartProduct.getNumProducts() == 0) {
                                outputFile.write("\tContains no items.\n");
                            } else {
                                outputFile.write("\tContains the following items:\n");

                                for (int i = 0; i < MocMartProduct.getNumProducts(); i++) {
                                    outputFile.write(products[i].toString());
                                }

                            }
                            break;
                            
                        case "RESTOCK":
                            
                            int restockCnt = 0;
                            for (int i = 0; i < MocMartProduct.getNumProducts(); i++) {
                                if (products[i].getQuantity() == 0) {
                                    products[i].setQuantity(products[i].getRestockQuantity());
                                    outputFile.write("\tItem " + products[i].getItemNum() + ", " + products[i].getItemName() + ", restocked to a quantity of " + products[i].getRestockQuantity() + ".\n");
                                    restockCnt++;
                                }
                            }
                            if (restockCnt == 0) {
                                outputFile.write("\tThere are no items to restock.\n");
                            }
                            break;
                            
                        case "FINDITEM":
                            
                            if (MocMartProduct.getNumProducts() == 0) {
                                outputFile.write("\tCannot perform command; there are no items in the product database.\n");
                            } else {
                                outputFile.write("\tPerforming Binary Search...(Indices viewed:");
                                int itemNum = Integer.valueOf(lineItems[1]); // ItemNum to be searched
                                MocMartProduct prod = binarySearch(products, itemNum, 0, MocMartProduct.getNumProducts() - 1,outputFile);
                                outputFile.write(")\n");

                                if (prod == null) {
                                    outputFile.write("\tItem #" + itemNum + " was not found in the product database.\n");
                                } else {
                                   
                                    outputFile.write("\tItem #" + prod.getItemNum() + " (" + prod.getItemName() + ")\n");
                                    outputFile.write("\tPrice            :  $" + prod.getItemPrice()+"\n");
                                    outputFile.write("\tCurrent Quantity :  " + prod.getQuantity()+"\n");
                                    outputFile.write("\tUnits Sold       :  "+prod.getUnitsSold()+"\n");
                                    outputFile.write("\tTotal Amount     :  "+prod.getUnitsSold()*prod.getItemPrice()+"\n");
                                }
                            }
                            break;
                            
                        case "ADDITEM":
                            
                            int itemNum = Integer.valueOf(lineItems[1]);
                            String itemName = lineItems[2];
                            double unitPrice = Double.valueOf(lineItems[3]);
                            int stockQty = Integer.valueOf(lineItems[4]);
                            int restockQty = Integer.valueOf(lineItems[5]);
                            // Find the insert index in the array
                            int insertIndex = 0;
                            boolean found = false;
                            for (int i = 0; i < MocMartProduct.getNumProducts(); i++) {
                                if (products[i] != null && products[i].getItemNum() > itemNum) {
                                    insertIndex = i;
                                    found = true;
                                    break;
                                }// Right shift the largest products
                            }
                            if (!found) {
                                insertIndex = MocMartProduct.getNumProducts();
                            } else {
                                for (int j = MocMartProduct.getNumProducts() - 1; j >= insertIndex; j--) {
                                    products[j + 1] = products[j];
                                }
                            }
                            products[insertIndex] = new MocMartProduct(itemNum, itemName, unitPrice, stockQty, restockQty);
                            outputFile.write("\tItem " + itemNum + ", " + itemName + ", with a cost of $" + unitPrice + " and initial stock of " + stockQty + ", has been added to the product database.\n");
                            break;
                            
                        case "CUSTOMER":
                            
                            String firstName = lineItems[1];
                            String lastName = lineItems[2];
                            int purchaseNumItemsOnList = Integer.valueOf(lineItems[3]);
                            int[] itemsPurchased = new int[purchaseNumItemsOnList];
                            for (int i = 0; i < purchaseNumItemsOnList; i++) {
                                itemsPurchased[i] = Integer.valueOf(lineItems[4 + i]);
                            }
                            
                            int numItemsOnList = 0 ;
                            for (int i = 0; i < purchaseNumItemsOnList; i+=2) {
                                
                                int purchanseItemNum = itemsPurchased[i] ;
                                int purchanseItemQty = itemsPurchased[i+1] ;
                                int purchaseableQty =  0 ;
                               
                                MocMartProduct prod = findProduct(products, purchanseItemNum) ;
                                if (prod == null || (prod.getQuantity() == 0)) // Not available
                                     itemsPurchased[i+1] = 0 ;
                                else if ( ( prod.getQuantity() - purchanseItemQty ) < 0 ) // partially available
                                {
                                    purchaseableQty =  prod.getQuantity() ;
                                    prod.setQuantity(0);
                                    itemsPurchased[i+1] = purchaseableQty;
                                    prod.setUnitsSold(prod.getUnitsSold()+purchaseableQty);
                                    numItemsOnList = numItemsOnList + purchaseableQty ;
                                }
                                else  // fully available
                                {
                                    purchaseableQty = purchanseItemQty ;
                                    prod.setQuantity(prod.getQuantity()- purchaseableQty) ;
                                    itemsPurchased[i+1] = purchaseableQty;
                                     prod.setUnitsSold(prod.getUnitsSold()+purchaseableQty);
                                    numItemsOnList = numItemsOnList + purchaseableQty ;
                                    
                                }
                            }
                            
                            if (numItemsOnList > 0)
                            {
                               // System.out.println("++ CUSTOMER => "+ firstName+"  "+lastName+" "+numItemsOnList+" "+Arrays.toString(itemsPurchased));
                                sales[MocMartSale.getNumSales()] = new MocMartSale(firstName, lastName, numItemsOnList, itemsPurchased);
                               
                            }
                            outputFile.write("\tCustomer " + firstName + " " + lastName + " came and made some purchases.\n");
                            break;
                            
                        case "PRINTSALESSUMMARY":
                            
                            outputFile.write("FCIT Baqalah Sales Report:\n");
                            double grandTotal = 0 ;
                            for (int s = 0; s < MocMartSale.getNumSales(); s++) {
                                MocMartSale sale = sales[s];
                                int itemsPurchasedCnt = sale.getNumItemsOnList();
                                int[] items = sale.getItemsPurchased();
                                outputFile.write("Sale #" + (s + 1) + ", " + sale.getFirstName() + " " + sale.getLastName() + " purchased " + sale.getNumItemsOnList() + " item(s).\n");
                                // System.out.println("++ PRINTSALESSUMMARY =>"+Arrays.toString(sale.getItemsPurchased()));
                                double total = 0 ;
                                for (int i = 0; i < items.length; i += 2) {
                                    MocMartProduct prod = findProduct(products, items[i]);
                                    if (prod != null && items[i + 1] !=0) {
                                        outputFile.write(String.format("\t \t| Item %6d | %20s | $%7.2f (x%4d) |\n", prod.getItemNum(), prod.getItemName(), prod.getItemPrice(), (items[i + 1])));
                                        total = total + (prod.getItemPrice() * items[i + 1]) ;
                                        //System.out.println("\t\t| Item   "+prod.getItemNum()+" | "+prod.getItemName()+"           | $  "+prod.getItemPrice()+" (x   "+items[i+1]+") |");
                                    }
                                  
                                }
                                outputFile.write(String.format("\t\tTotal: $%7.2f\n",total)); 
                                grandTotal = grandTotal + total ;
                            }
                            outputFile.write(String.format("\tGrand Total: $%7.2f\n",grandTotal));  
                            break;
                            
                        case "QUIT":
                            
                            outputFile.write("Goodbye.\n");
                            break;
                            
                        default:
                            break;
                    }
                }
            }

            inputFile.close();     //closes the scanner  
            outputFile.close() ;
        } catch (Exception ex) {
            System.out.println("Exception while reading from file or writing to file");
            ex.printStackTrace();
        }

    }

}
