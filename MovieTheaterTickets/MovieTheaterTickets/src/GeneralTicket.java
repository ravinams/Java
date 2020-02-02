
public class GeneralTicket extends Ticket implements TotalCostForTicket
{
     private double totalPrice;
    
      public GeneralTicket(int theaterNumber, int seatNumber, boolean reservedTicketSold) {
          super(theaterNumber,seatNumber,reservedTicketSold) ;  
          totalPrice = calculateTotalPrice() ;
    }
      
      public double calculateTotalPrice()
      {
         return Ticket.basePrice + taxRate ;                
      }
      
       public String toString() {
        return super.toString() + String.format("GENERAL ADMISSION the price is $%.2f",totalPrice);
    }
      
} 