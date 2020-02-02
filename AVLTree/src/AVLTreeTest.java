
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Book {

    int ISBN;

    public Book(int ISBN) {
        this.ISBN = ISBN;
    }

}

class AVLNode {

    AVLNode left, right;

    Book book;

    int height;

    public AVLNode(Book book) {

        left = null;

        right = null;

        this.book = book;

        height = 0;

    }

}

class AVLTree {

    private AVLNode root;

    public AVLTree() {

        root = null;

    }

    public void insert(Book book) {

        root = insert(book, root);

    }

    private int height(AVLNode t) {

        return t == null ? -1 : t.height;

    }

    private int max(int lhs, int rhs) {

        return lhs > rhs ? lhs : rhs;

    }

    private AVLNode insert(Book book, AVLNode top) {

        if (top == null) {
            top = new AVLNode(book);
        } else if (book.ISBN < top.book.ISBN) {
            top.left = insert(book, top.left);

            if (height(top.left) - height(top.right) == 2) {

                System.out.print("Imbalance occurred at inserting ISBN " + book.ISBN);

                if (book.ISBN < top.left.book.ISBN) {
                    System.out.println("; fixed in Left Rotation");
                    top = rotateWithLeftChild(top);
                } else {
                    System.out.println("; fixed in RightLeft Rotation");
                    top = doubleWithLeftChild(top);
                }

            }

        } else if (book.ISBN > top.book.ISBN) {

            top.right = insert(book, top.right);

            if (height(top.right) - height(top.left) == 2) {

                System.out.print("Imbalance occurred at inserting ISBN " + book.ISBN);

                if (book.ISBN > top.right.book.ISBN) {
                    System.out.println("; fixed in Right Rotation");
                    top = rotateWithRightChild(top);

                } else {
                    System.out.println("; fixed in LeftRight Rotation");
                    top = doubleWithRightChild(top);
                }

            }

        }

        top.height = max(height(top.left), height(top.right)) + 1;

        return top;

    }

    private AVLNode rotateWithLeftChild(AVLNode k2) {

        AVLNode k1 = k2.left;

        k2.left = k1.right;

        k1.right = k2;

        k2.height = max(height(k2.left), height(k2.right)) + 1;

        k1.height = max(height(k1.left), k2.height) + 1;

        return k1;

    }

    private AVLNode rotateWithRightChild(AVLNode k1) {

        AVLNode k2 = k1.right;

        k1.right = k2.left;

        k2.left = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;

        k2.height = max(height(k2.right), k1.height) + 1;

        return k2;

    }

    private AVLNode doubleWithLeftChild(AVLNode k3) {

        k3.left = rotateWithRightChild(k3.left);

        return rotateWithLeftChild(k3);

    }

    private AVLNode doubleWithRightChild(AVLNode k1) {

        k1.right = rotateWithLeftChild(k1.right);

        return rotateWithRightChild(k1);

    }

    public void inorder() {

        inorder(root);

    }

    private void inorder(AVLNode r) {

        if (r != null) {

            inorder(r.left);

            System.out.print(r.book.ISBN + " ");

            inorder(r.right);

        }

    }
}

public class AVLTreeTest {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("Books.txt"));
        AVLTree avlt = new AVLTree();

        while (in.hasNextLine()) {
            Book book = new Book(in.nextInt());
            avlt.insert(book);
        }

        System.out.print("\nIn order : ");
        avlt.inorder();

        in.close();

    }

}
