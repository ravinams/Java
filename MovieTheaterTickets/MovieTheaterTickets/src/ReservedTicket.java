
public class ReservedTicket extends Ticket implements TotalCostForTicket {

    private double totalPrice;

    public ReservedTicket(int theaterNumber, int seatNumber, boolean reservedTicketSold) {
        super(theaterNumber, seatNumber, reservedTicketSold);

        totalPrice = calculateTotalPrice();
    }

    @Override
    public double calculateTotalPrice() {
        // adds the basePrice and the premium together and adds the tax to calculate totalPrice
        return basePrice + 3.50 + taxRate; //premium in MovieHouse class
    }

    public String toString() {
        return super.toString() + String.format(" RESERVED the price is $%.2f", totalPrice);
    }

}
