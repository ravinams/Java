
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class MovieHouse {

    ArrayList<Ticket> theater0 ;
    ArrayList<Ticket> theater1 ;
    ArrayList<Ticket> theater2 ;

    private PrintWriter outputWriter;
    private String movieHouseName; // MovieHouse name
    public static double premium = 3.50; //premium added to reserved tickets
    private boolean theaterSeats[][] ; // three rows, constructor will have the variables needed to construct each row. 

    public MovieHouse(String movieHouseName, int theater0NumOfSeats, int theater1NumOfSeats, int theater2NumOfSeats) {
        this.movieHouseName = movieHouseName;
        
         theater0 = new ArrayList<>();
         theater1 = new ArrayList<>();
         theater2 = new ArrayList<>();
         theaterSeats= new boolean[3][] ;
    
        theaterSeats[0] = new boolean[theater0NumOfSeats];
        theaterSeats[1] = new boolean[theater1NumOfSeats];
        theaterSeats[2] = new boolean[theater2NumOfSeats];

    }

    public void setOutputWriter(PrintWriter outputWriter) {
        this.outputWriter = outputWriter; //sets the PrintWriter instance variable 
    }

    public void startSales(int theaterNumber) {
        
        Random rand = new Random((5 * theaterNumber) + 10);

        int totalSeats = 0;

        if (theaterNumber == 0) {
            totalSeats = theaterSeats[0].length;
        } else if (theaterNumber == 1) {
            totalSeats = theaterSeats[1].length;
        } else if (theaterNumber == 2) {
            totalSeats = theaterSeats[2].length;
        }

        int halfNumberSeats = totalSeats / 2;

        int noOfTicketsTobeSold = rand.nextInt(halfNumberSeats - 1) + halfNumberSeats;

        int ticketCreationStatus = -1;
        for (int i = 0; i < noOfTicketsTobeSold - 1; i++) {
            int tickerNumber = rand.nextInt(totalSeats - 1);

            if (tickerNumber % 3 == 0) {  // third ticket starting with the 0TH
                ticketCreationStatus = sellTicket(new ReservedTicket(theaterNumber, tickerNumber, true));
            } else {
                ticketCreationStatus = sellTicket(new GeneralTicket(theaterNumber, tickerNumber, false));
            }
            if (ticketCreationStatus != 0) // If the status is not zero you must retry to create this ticket (i.e. decrement the counter).
            {
                i--;
            }
        }

    }

    public int sellTicket(Ticket ticket) {
        int theaterNumber = ticket.getTheaterNumber();
        int seatNumber = ticket.getSeatNumber();

        if (theaterNumber < 0 || theaterNumber > 2) {
            return 1;
        } else if ( seatNumber < 0 || seatNumber > (theaterSeats[theaterNumber].length - 1) ) {
            return 2;
        } else if (ticket.getTicketSold() == true) {

            return 3;
        } else {
            theaterSeats[theaterNumber][seatNumber] = true;
            if (theaterNumber == 0) {
                theater0.add(ticket);
            }
            if (theaterNumber == 1) {
                theater1.add(ticket);
            }
            if (theaterNumber == 2) {
                theater2.add(ticket);
            }
            return 0;
        }
    }

    public void printSeatMaps() {

        outputWriter.println("Welcome to " + movieHouseName);

        ArrayList<Ticket> theater = null;

        for (int j = 0; j < 3; j++) {
            outputWriter.println("\nTheater " + j + " Seat Map \n");
            int i = 0;

            if (j == 0) {
                theater = theater0;
            } else if (j == 1) {
                theater = theater1;
            } else if (j == 2) {
                theater = theater2;
            }

            for (Ticket ticket : theater) {

                i++;
                if (ticket.getReservedTicketSold() || ticket.getTicketSold()) {
                    outputWriter.print("V ");
                } else {
                    outputWriter.print("S ");
                }

                if (i % 10 == 0) // groups of 10 to the output file                
                {
                    outputWriter.print("\n");
                }

            }
            outputWriter.print("\n");
        }
    }

    public void printSalesRecords() {

        ArrayList<Ticket> theater = null;

        for (int j = 0; j < 3; j++) {
            outputWriter.println("\nThe TicketRecord For Theater" + j);

            if (j == 0) {
                theater = theater0;
            } else if (j == 1) {
                theater = theater1;
            } else if (j == 2) {
                theater = theater2;
            }

            for (Ticket ticket : theater) {
                outputWriter.println(ticket);
            }
        }

    }

}
