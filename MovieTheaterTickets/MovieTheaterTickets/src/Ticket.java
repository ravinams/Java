
public abstract class Ticket {

    //instance variables
    public static double basePrice;
    private int theaterNumber; // 0, 1, or 2
    private int seatNumber; // range from 0 to one less than the total number of seats
    private boolean ticketSold = false; // set to true if ticket is sold
    private boolean reservedTicketSold = false; // set to true if reserved ticket is sold

    //constructor that accepts as the input the theater number, seat number, and variable indicating if the seat is reserved
    public Ticket(int theaterNumber, int seatNumber, boolean reservedTicketSold) {
        this.theaterNumber = theaterNumber;
        this.seatNumber = seatNumber;
        this.reservedTicketSold = reservedTicketSold;
    }

    public int getTheaterNumber() {
        return theaterNumber;
    }

    public void setTheaterNumber(int tn) {
        theaterNumber = tn;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int sn) {
        seatNumber = sn;
    }

    public boolean getReservedTicketSold() {
        return reservedTicketSold;
    }

    public void getReservedTicketSold(boolean rts) {
        reservedTicketSold = rts;
    }

    public boolean getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(boolean ts) {
        ticketSold = ts;
    }

    public boolean equals(Ticket other) {
        if (theaterNumber == other.getTheaterNumber() && seatNumber == other.getSeatNumber()) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("For Theater %d seat number %d which is", getTheaterNumber(), getSeatNumber());
    }

}
