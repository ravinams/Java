import java.util.Scanner;
public class SortPurchasesArray
{
   public static void main(String[] args)
   {
      Purchase[] purchases = new Purchase[5];
     
      String message;
      int choice;     
      int number;
      double price, tax ;
      Scanner keyboard = new Scanner(System.in);
      for(int i = 0; i < purchases.length; ++i)
      {
         System.out.print("\nEnter invoice number : ");
         number = keyboard.nextInt();
         System.out.print("Enter sale amount : ");
         price = keyboard.nextDouble();
         System.out.print("Enter sale tax amount : ");
         tax = keyboard.nextDouble();
         purchases[i] = new Purchase();
         purchases[i].setInvoiceNumber(number);
         purchases[i].setSaleAmount(price);
         purchases[i].setSaleTaxAmount(tax);
      }
      keyboard.nextLine();
      
      do
      {
      System.out.print("\n1) Sort by Invoice. 2) Sort by Amount of Sale. 3) Sort by Sales Tax. 0) Exit  : ");
      choice = keyboard.nextInt();
      
         if(choice == 1)
         {
             sortByInvoice(purchases);
             System.out.println("\nSorted by invoice number\n"); 
             display(purchases);       
         }
         else
           if(choice == 2)
           {
              sortBySaleAmount(purchases);
              System.out.println("\nSorted by sale amount\n");
              display(purchases);
           }
            if(choice == 3)
           {
              sortBySaleTaxAmount(purchases);
              System.out.println("\nSorted by sale amount\n");
              display(purchases);
           }
           else
              System.out.println("Invalid choice");        
      } while(choice!=0) ;
   }
   public static void sortBySaleAmount(Purchase[] array)
   {
      
      Purchase temp;
      int highSub = array.length - 1;
      for (int a = 0; a < highSub; ++a)
      {
         for (int b = 0; b < highSub; ++b)
         if(array[b].getSaleAmount() > array[b + 1].getSaleAmount())
         {
            temp = array[b];
            array[b] = array[b + 1];
            array[b + 1] = temp;
          }
        }
    }
    public static void sortBySaleTaxAmount(Purchase[] array)
    {
    
        Purchase temp;
        int highSub = array.length - 1;
        for (int a = 0; a < highSub; ++a)
        {
           for (int b = 0; b < highSub; ++b)
           if (array[b].getSaleTaxAmount() > array[b + 1].getSaleTaxAmount())
           {
              temp = array[b];
              array[b] = array[b + 1];
              array[b + 1] = temp;
           }
        }
     }

     public static void sortByInvoice(Purchase[] array)
    {
        int a, b;
        Purchase temp;
        int highSub = array.length - 1;
        for (a = 0; a < highSub; ++a)
        {
           for (b = 0; b < highSub; ++b)
           if (array[b].getInvoiceNumber() > array[b + 1].getInvoiceNumber())
           {
              temp = array[b];
              array[b] = array[b + 1];
              array[b + 1] = temp;
           }
        }
     }
     public static void display(Purchase[] p)
     {
        
        for (int i = 0; i < p.length; i++)
           System.out.println(p[i]);
     }
}