//This is a java program to check whether a tree is AVL tree or not

import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;

class BTNode {

    int element;
    BTNode Left;
    BTNode Right;

    BTNode(int k) {
        element = k;
    }
}

public class RandomBinaryTree {

    public static boolean isBalanced(BTNode root) {
        int Lh;
        /* Left subtree height */
        int Rh;
        /* Right subtree height */

        if (root == null) {
            return true;
        }

        Lh = height(root.Left);
        Rh = height(root.Right);

        if (Math.abs(Lh - Rh) <= 1 && isBalanced(root.Left)
                && isBalanced(root.Right)) {
            return true;
        }

        return false;
    }

    public static boolean isBST(BTNode node) {
        return (isBSTUtil(node, 0, 100));
    }

    public static boolean isBSTUtil(BTNode node, int min, int max) {

        if (node == null) {
            return true;
        }

        if (node.element < min || node.element > max) {
            return false;
        }

        return (isBSTUtil(node.Left, min, node.element - 1) && isBSTUtil(node.Right, node.element + 1, max));
    }

    public static int height(BTNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + max(height(node.Left), height(node.Right));
    }

    public static int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    public static BTNode insert(BTNode root, int v) {
        if (root == null) {
            root = new BTNode(v);

        } else if (v < root.element) {
            root.Left = insert(root.Left, v);
        } else {
            root.Right = insert(root.Right, v);
        }

        return root;
    }
    
     // Iterative method to do level order traversal line by line
    static void printLevelOrder(BTNode root)
    {
        // Base Case
        if(root == null)
            return;
         
        // Create an empty queue for level order tarversal
        Queue<BTNode> q =new LinkedList<BTNode>();
         
        // Enqueue Root and initialize height
        q.add(root);
         
         
        while(true)
        {
             
            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if(nodeCount == 0)
                break;
             
            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while(nodeCount > 0)
            {
                BTNode node = q.peek();
                System.out.print(node.element + " ");
                q.remove();
                if(node.Left != null)
                    q.add(node.Left);
                if(node.Right != null)
                    q.add(node.Right);
                nodeCount--;
            }
            System.out.println();
        }
    }
    

    public static void main(String args[]) {

        Random random = new Random();
        // Randomly generating tree values

        BTNode t1 = new BTNode(random.nextInt(100));

        for (int i = 0; i < 6; i++) {
            insert(t1, random.nextInt(100));
        }

        // the below two lines are optional .. just to print the tree data
        System.out.println("++ printing t1 tree ++");
        printLevelOrder(t1);
        
        BTNode t2 = new BTNode(random.nextInt(100));

        for (int i = 0; i < 6; i++) {
            insert(t2, random.nextInt(100));
        }
        
         // the below two lines are optional .. just to print the tree data
         System.out.println("\n ++ Printing t2 tree +++");
         printLevelOrder(t2);

         System.out.println("\n");
         
        if (isBST(t1) && isBalanced(t1)) {
            System.out.println("t1 TREE is an AVL tree");
        } else {
            System.out.println("t1 TREE is not an AVL tree");
        }

        if (isBST(t2) && isBalanced(t2)) {
            System.out.println("t2 TREE is an AVL tree");
        } else {
            System.out.println("t2 TREE is not an AVL tree");
        }
    }
}
