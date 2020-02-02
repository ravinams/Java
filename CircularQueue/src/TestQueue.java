
import java.util.Scanner;

/**
 *
 * @author onkar
 */
public class TestQueue {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Circular_Queue cq = new Circular_Queue();
        char ch;
        do {
            System.out.println("\nQueue Operations");
            System.out.println("1. Insert an element");
//            System.out.println("2. Remove an element");
//            System.out.println("3. Peek");
//            System.out.println("4. Check if the Queue is Empty");
//            System.out.println("5. Queue_Size");
            System.out.println("6. Quit");
            System.out.print("Enter your choice:");
            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter the string you want to insert:");
                    cq.enqeue(scan.nextLine());
                    break;

                case 2:
                    try {
                        System.out.println("Removed Element = " + cq.dequeue());
                    } catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Peek Element = " + cq.peek());
                    } catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Empty status = " + cq.isEmpty());
                    break;

                case 5:
                    System.out.println("Queue_Size = " + cq.size());
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong Entry.\n");
                    break;
            }

            System.out.println("");
            System.out.println(cq.toString());

//            System.out.println("\nPress Y/y to continue or press Q/q to Quit: \n");
//            String str = scan.nextLine();
//            ch = str.charAt(0);
        } while (true);        

    }
}
