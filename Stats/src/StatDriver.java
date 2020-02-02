
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program reads some numbers from the terminal and calculates their mean
 * and standard deviation.
 *
 * @author Farzana Rahman
 * @version 10/17/2016
 *
 */
public class StatDriver {

    /**
     * Reads numbers and prints their mean and standard deviation to the
     * terminal.
     *
     * @param args - args[0] should contain the number of values that will be
     * read, 15 is the default if no command line argument is provided
     */
    public static void main(String[] args) {

        Scanner input;
        ArrayList<Double> data = new ArrayList<Double>();;
        String choice = "mean"; // default choice 

        // check the parameters
        if (args.length > 0) {
            choice = args[0];
        }

        // Read values from the terminal.
        input = new Scanner(System.in);
        // enter any non-digit to stop the loop like 'done'
        while (input.hasNextDouble()) {
            data.add(input.nextDouble());
        }

        // Calculate and display the results.
        if ("mean".equalsIgnoreCase(choice)) {
            System.out.printf("Mean: %.2f\n", Stats.mean(data));
        } else if ("std".equalsIgnoreCase(choice)) {
            System.out.printf("StdDev: %.2f\n", Stats.stdDev(data));
        } else if ("median".equalsIgnoreCase(choice)) {
            System.out.printf("median: %.2f\n", Stats.median(data));
        }
    }

}
