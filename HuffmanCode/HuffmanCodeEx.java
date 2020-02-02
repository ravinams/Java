import java.util.PriorityQueue; // required imports
import java.util.Scanner;

public class HuffmanCodeEx { // class to run the code
  
    public static HuffmanCodingTree createTree(int[] characterFreqs) { // input an array of frequencies

        PriorityQueue<HuffmanCodingTree> huffmantree = new PriorityQueue<>(); // implement the queue to sor the data

        for (int i = 0; i < characterFreqs.length; i++) { // iterate over the length of the array
            if (characterFreqs[i] > 0) { // check for the frequency of each character
                huffmantree.offer(new HuffmanCodingLeaf(characterFreqs[i], (char) i)); // save the data to the queue
            }
        }

        while (huffmantree.size() > 1) { // looping until there is only one tree left over

            HuffmanCodingTree a = huffmantree.poll(); // two trees with null values
            HuffmanCodingTree b = huffmantree.poll();

            huffmantree.offer(new HuffmanCodingNode(a, b));
        }
        return huffmantree.poll(); // return the data
    }

    public static void displayData(HuffmanCodingTree tree, StringBuffer code) { // method to display the data
      
        if (tree != null) { // check for null data in the tree
            if (tree instanceof HuffmanCodingLeaf) { // check for the object type
                HuffmanCodingLeaf leaf = (HuffmanCodingLeaf) tree;

                System.out.println(leaf.value + " \t\t " + leaf.frequency + " \t\t" + code); // print the data to console
              

            } else if (tree instanceof HuffmanCodingNode) {
                HuffmanCodingNode node = (HuffmanCodingNode) tree;

                // traverse to the left of the tree
                code.append('0');
                displayData(node.left, code);
                code.deleteCharAt(code.length() - 1);

                // traverse to the right of the tree
                code.append('1');
                displayData(node.right, code);
                code.deleteCharAt(code.length() - 1);
            }
        }
    }

    public static void main(String[] args) { //driver method
    
         
         System.out.print("Enter a text:");
         Scanner in = new Scanner(System.in);
         String test = in.nextLine();
        //String test = "this is an example"; // sample string
        test = test.toLowerCase(); // converting to lower case if any upper case found
        int[] characterFreqs = new int[256]; // initialisaing the array with the max value for temporary purpose

        for (char c : test.toCharArray()) { // read the each character and count the frequencies
            characterFreqs[c]++;
        }

        HuffmanCodingTree hTree = createTree(characterFreqs); // create the tree for th egiven frequencies

        System.out.println("Charcter\tFrequency\tCode Word"); // print the results to console
        System.out.println("-------------------------------------------");
        displayData(hTree, new StringBuffer()); // call the method to print the data
        System.out.println("-------------------------------------------");
    }
}

class HuffmanCodingTree implements Comparable<HuffmanCodingTree> { // class used to compare the frequencies

    public final int frequency; // the frequency of this tree

    public HuffmanCodingTree(int freq) { // parameterised constructor
        frequency = freq;
    }
  
    @Override
    public int compareTo(HuffmanCodingTree tree) { // compares on the frequency
        return frequency - tree.frequency;
    }
}

class HuffmanCodingLeaf extends HuffmanCodingTree {

    public final char value; // the character this leaf represents

    public HuffmanCodingLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}

class HuffmanCodingNode extends HuffmanCodingTree {

    public final HuffmanCodingTree left, right; // subtrees

    public HuffmanCodingNode(HuffmanCodingTree l, HuffmanCodingTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}
