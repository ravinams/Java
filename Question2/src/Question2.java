
import java.util.Scanner;

public class Question2 {

   
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.print("Enter weight in kilograms: ");
        int weight = myInput.nextInt();
        System.out.print("Enter height in meters: ");
        int height = myInput.nextInt();
        double BMI = weight / (height * height);
        System.out.print("\nThe Body Mass Index (BMI) is " + BMI + " kg/m2");
    }

}
