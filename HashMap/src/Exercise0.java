
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Exercise0 {

    public static void main(String args[]) {

        int tableSize = 0, keysCnt = 0;

        Scanner inputsc = new Scanner(System.in);

        System.out.print("What size hastable do you want to work with  \nEnter a positive number: ");
        tableSize = inputsc.nextInt();
        System.out.print("How many keys do you want to generate ? \nEnter a positive number: ");
        keysCnt = inputsc.nextInt();

        ArrayList<LinkedList<Integer>> table = new ArrayList(tableSize);
        for (int i = 0; i < tableSize; i++) {
            table.add(new LinkedList<Integer>());
        }

        Random ran = new Random();

        for (int i = 0; i < keysCnt; i++) {
            Integer randomValue = ran.nextInt(10000);
            int hashKey = randomValue % tableSize;

            LinkedList<Integer> collisionList = table.get(hashKey);
            if (collisionList == null) {
                collisionList = new LinkedList();
                collisionList.add(randomValue);
                table.set(hashKey, collisionList);
            } else {
                collisionList.add(randomValue);
            }
        }

        System.out.println("Hash Table created: ");
        // System.out.println(table);
        int numCollisions = 0, longestLLSize = 0;
        for (int i = 0; i < tableSize; i++) {
            LinkedList<Integer> valuesList = table.get(i);
            // System.out.println(valuesList +" ->");
            if (valuesList == null || valuesList.isEmpty()) {
                System.out.print("-->empty ");
            } else {

                for (int l = 0; l < valuesList.size(); l++) {
                    System.out.print("-->" + valuesList.get(l));
                }
            }

            if (valuesList.size() > 1) {
                numCollisions++;
            }

            if (longestLLSize < valuesList.size()) {
                longestLLSize = valuesList.size();
            }

            System.out.println();
        }

        System.out.println("\n\nStatistics :");
        System.out.println("Table size :" + tableSize);
        System.out.println("Number of keys :" + keysCnt);
        System.out.println("Load factor :" + keysCnt / tableSize);
        System.out.println("Number Of collisions :" + numCollisions);
        System.out.println("Longest list :" + longestLLSize);

    }

}
