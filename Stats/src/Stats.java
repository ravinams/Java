
import java.util.ArrayList;

/**
 * Utility methods for calculating statistics.
 *
 * @author Farzana Rahman
 * @version 10/17/2016
 *
 */
public class Stats {

    /**
     * Calculate the mean of a collection of doubles.
     *
     * @param numbers - The array of doubles
     * @return The mean, or Double.NaN if the array is empty or null
     */
    public static double mean(ArrayList<Double> numbers) {
        double total = 0;
        double result;

        if (numbers == null || numbers.size() == 0) {
            result = Double.NaN;
        } else {

            for (int i = 0; i < numbers.size(); i++) {
                total += numbers.get(i);
            }
            result = total / numbers.size();
        }
        return result;
    }

    /**
     * Calculate the standard deviation of a collection of doubles.
     *
     * @param numbers - The array of doubles
     * @return The standard deviation, or Double.NaN if the array is empty or
     * null
     */
    public static double stdDev(ArrayList<Double> numbers) {
        double mean;
        double total = 0;
        double result;

        if (numbers == null || numbers.size() == 0) {
            result = Double.NaN;
        } else {
            mean = mean(numbers);
            for (int i = 0; i < numbers.size(); i++) {
                total += Math.pow((mean - numbers.get(i)), 2);
            }
            result = Math.sqrt(total / numbers.size());
        }
        return result;
    }

    /**
     * Calculate the median of a collection of doubles.
     *
     * @param numbers - The array of doubles
     * @return - median
     *
     */
    public static double median(ArrayList<Double> numbers) {
        double median = 0;
        if (numbers == null || numbers.size() == 0) {
            median = Double.NaN;
        } else {
            numbers.sort(null) ;

            // Calculate median (middle number)          
            double pos1 = Math.floor((numbers.size() - 1.0) / 2.0);
            double pos2 = Math.ceil((numbers.size() - 1.0) / 2.0);
            if (pos1 == pos2) {
                median = numbers.get((int) pos1);
            } else {
                median = (numbers.get((int) pos1) + numbers.get((int) pos2)) / 2.0;
            }

        } 

        return median;
    }

}
