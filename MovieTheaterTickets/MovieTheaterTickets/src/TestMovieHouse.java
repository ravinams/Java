
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestMovieHouse {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter the name of the movie house: ");
        String movieHouseName = userInput.nextLine();

        System.out.println("Please enter the number of seats in theaters 0, 1, and 2 as integers.");
        System.out.print("Maximum 40 seats per theater:");
        int numOfSeatsTheater0 = userInput.nextInt();
        int numOfSeatsTheater1 = userInput.nextInt();
        int numOfSeatsTheater2 = userInput.nextInt();

        //create a movie head based on above data.
        MovieHouse mh = new MovieHouse(movieHouseName, numOfSeatsTheater0, numOfSeatsTheater1, numOfSeatsTheater2);
        System.out.print("Please enter the base price of a ticket:");

        double basePrice = userInput.nextDouble();

        Ticket.basePrice = basePrice;

        userInput.nextLine();// dummy to skip newline
        System.out.print("Enter the name of the output file:");

        String fileName = userInput.nextLine();

        //System.out.println(" ==>" + movieHouseName +" "+ numOfSeatsTheater0 +" "+ numOfSeatsTheater1 +" "+ numOfSeatsTheater2 +" "+basePrice+ " "+fileName);
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new File(fileName));

            mh.setOutputWriter(printWriter);

            mh.startSales(0);
            mh.startSales(1);
            mh.startSales(2);

            mh.printSeatMaps();
            mh.printSalesRecords();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }

}
