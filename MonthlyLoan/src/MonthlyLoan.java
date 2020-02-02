
import java.util.Scanner;
import java.util.InputMismatchException;

public class MonthlyLoan {

    public static void main(String[] args) {

        try {

            double startAnnualInterest;

            double endAnnualInterest;

            double incrementAnnualInterest;

            int firstTerm;

            int lastTerm;

            int incrementTerm;

            double amountLoaned;

            Scanner input = new Scanner(System.in);

            System.out.print("Enter the starting annual intererst rate as a percent (n.nnn)    : ");

            startAnnualInterest = input.nextDouble();

            double startInterestRate = startInterest(startAnnualInterest);

            while (startAnnualInterest < 1) {

                System.out.println("Please enter number greater than 0.");

                System.out.println("");

                System.out.print("Enter the starting annual intererst rate as a percent (n.nnn)    : ");

                startAnnualInterest = input.nextDouble();

                startInterestRate = startInterest(startAnnualInterest);

            }				// End While

            System.out.print("Enter the ending annual intererst rate as a percent (n.nnn)      : ");

            endAnnualInterest = input.nextDouble();

            double endInterestRate = endInterest(endAnnualInterest);

            while (startAnnualInterest > endAnnualInterest) {

                System.out.println("Please enter number greater than starting annual interest rate.");

                System.out.println("");

                System.out.print("Enter the ending annual intererst rate as a percent (n.nnn)    : ");

                endAnnualInterest = input.nextDouble();

                endInterestRate = endInterest(endAnnualInterest);

            }				// End While

            System.out.print("Enter the annual intererst rate increment as a percent (n.nnn)   : ");

            incrementAnnualInterest = input.nextDouble();

            double incrementInterestRate
                    = incrementInterest(incrementAnnualInterest);

            while (endAnnualInterest <= 0) {

                System.out.println("Please enter number greater than 0.");

                System.out.println("");

                System.out.print("Enter the annual intererst rate increment as a percent (n.nnn)   : ");

                incrementAnnualInterest = input.nextDouble();

                incrementInterestRate = incrementInterest(incrementAnnualInterest);

            }				// End While

            System.out.print("Enter the first term in years for calculating payments           : ");

            firstTerm = input.nextInt();

            while (firstTerm < 1) {

                System.out.println("Please enter number greater than 0.");

                System.out.println("");

                System.out.print("Enter the first term in years for calculating payments           : ");

                firstTerm = input.nextInt();

            }				// End While

            System.out.print("Enter the last term in years for calculating payments            : ");

            lastTerm = input.nextInt();

            while (firstTerm > lastTerm) {

                System.out.println("Please enter number greater than the first term.");

                System.out.println("");

                System.out.print("Enter the last term in years for calculating payments            : ");

                lastTerm = input.nextInt();

            }				// End While

            System.out.print("Enter the term increment year                                    : ");

            incrementTerm = input.nextInt();

            while (incrementTerm <= 0) {

                System.out.println("Please enter number greater than 0.");

                System.out.println("");

                System.out.print("Enter the term increment year                                    : ");

                incrementTerm = input.nextInt();

            }				// End While

            System.out.print("Enter the loan amount                                            : ");

            amountLoaned = input.nextDouble();

            while (amountLoaned <= 0) {

                System.out.println("Please enter number greater than 0.");

                System.out.println("");

                System.out.print("Enter the loan amount                                            : ");

                amountLoaned = input.nextDouble();

            }				// End While

            paymentDetails(firstTerm, lastTerm, incrementTerm, startAnnualInterest, endAnnualInterest, incrementAnnualInterest, amountLoaned, startInterestRate, endInterestRate, incrementInterestRate);	// Display Payment Details
        } catch (InputMismatchException ex) {

            System.out.println("\nInput value read from the console doesn't match its data type, "
                    + ex.getMessage() + ".\n");

        }

    }

// Calculate Intermediate Values
    public static double
            incrementInterest(double incrementAnnualInterest) {

        final double interestRate = 0.01;

        double incrementInterestRate = (incrementAnnualInterest * interestRate);

        return incrementInterestRate;

    }

    public static double
            startInterest(double startAnnualInterest) {

        final double interestRate = 0.01;

        double startInterestRate = (startAnnualInterest * interestRate);

        return startInterestRate;

    }

    public static double
            startMir(double startInterestRate) {

        final int MONTHS_IN_A_YEAR = 12;

        double mir = startInterestRate / MONTHS_IN_A_YEAR;

        return mir;

    }

    public static double
            startMtp(int firstTerm) {

        final int MONTHS_IN_A_YEAR = 12;

        double mtp = firstTerm * MONTHS_IN_A_YEAR;

        return mtp;

    }

    public static double
            endInterest(double endAnnualInterest) {

        final double interestRate = 0.01;

        double endInterestRate = (endAnnualInterest * interestRate);

        return endInterestRate;

    }

    public static double
            endMir(double endInterestRate) {

        final int MONTHS_IN_A_YEAR = 12;

        double mir = endInterestRate / MONTHS_IN_A_YEAR;

        return mir;

    }

    public static double
            endMtp(int lastTerm) {

        final int MONTHS_IN_A_YEAR = 12;

        double mtp = lastTerm * MONTHS_IN_A_YEAR;

        return mtp;

    }

    public static void
            paymentDetails(int firstTerm, int lastTerm, int incrementTerm,
                    double startAnnualInterest, double endAnnualInterest,
                    double incrementAnnualInterest, double amountLoaned,
                    double startInterestRate, double endInterestRate,
                    double incrementInterestRate) {

                                        
        System.out.println("\nPayment Schedule:\n");

        System.out.println("Interest");

        System.out.print(" Rate     ");
//        for (int i = firstTerm; i <= lastTerm; i+= incrementTerm)
//            System.out.print(i+"Years"+" ");
//
//       System.out.println("");        
// Calculate Starting Annual Interest
//        double startMIR = startMir(startInterestRate);
//
//        double startMTP = startMtp(firstTerm);
//
//        double numeratorStart = startMIR * Math.pow((1 + startMIR), startMTP);
//
//        double denominatorStart = Math.pow((1 + startMIR), startMTP) - 1;
//
//        double totalStart = numeratorStart / denominatorStart;
//
//        double paymentStart = amountLoaned * totalStart;
//
//        // Calculate Ending Annual Interest
//        double endMIR = endMir(endInterestRate);
//
//        double endMTP = endMtp(lastTerm);
//
//        double numeratorEnd = endMIR * Math.pow((1 + endMIR), endMTP);
//
//        double denominatorEnd = Math.pow((1 + endMIR), endMTP) - 1;
//
//        double totalEnd = numeratorEnd / denominatorEnd;
//
//        double paymentEnd = amountLoaned * totalEnd;

        for (int i = firstTerm; i <= lastTerm; i+= incrementTerm) {

            System.out.format("  %d Years  ", i);

        }				// End For
        System.out.println("");

        for (double j = startAnnualInterest; j <= endAnnualInterest; j+= incrementAnnualInterest) {

            System.out.format(" %1.4f     ", j);

            double mir = ( j* 0.01)/12   ;
            
            for (int k = firstTerm; k <= lastTerm; k+= incrementTerm) {

                // System.out.format(" %1.2f     ", k);
                // System.out.format(" %d     ", k);
                 
                 int mtp = k * 12  ;
                 
                 double annuityNumerator = mir*Math.pow((1+mir), mtp) ; // startMIR * Math.pow((1 + startMIR), startMTP);
                 double annuityDenominator = Math.pow((1+mir),mtp)-1 ;   // Math.pow((1 + endMIR), endMTP) - 1;
                 
                 double payment  = ( annuityNumerator/annuityDenominator ) * amountLoaned ;
                 System.out.format(" %1.2f     ", payment);
                 //System.out.print(payment);

            }

            System.out.println();

        }				// End For
    }

}
