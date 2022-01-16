
import java.util.LinkedList;

public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {

	private Node<T> root;

	public BinaryTreeImpl() {
		root = null;
	}

	public BinaryTreeImpl(Node<T> r) {
		root = r;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void add(T data) {
		root = insert(root, data);

	}

	private Node<T> insert(Node<T> root, T data) {

		if (root == null) { // if the root is empty , then this node will be root .
			return new Node<T>(data);
		}

		else if (data.compareTo(root.data) < 0) {   // if the new node's health index value is less the current node  , then insert it into left tree
			root.left = insert(root.left, data);
		}

		else if (data.compareTo(root.data) > 0) { // if the new node's health index value is greater the current node  , then insert it into left tree
			root.right = insert(root.right, data);
		} else {
			// Stylistically, I have this here to explicitly state that we are
			// disallowing insertion of duplicate values.
			;
		}

		return root;
	}

	public int count() {
		return count(root);
	}

	@SuppressWarnings("unchecked")
	private int count(Node<T> rootNode) {
		if (rootNode == null) { // if the root is empty , then count is 0  
			return 0; 
		} else { // otherwise recursively count the both left and right tree
			return 1 + count(rootNode.left) + count(rootNode.right);
		}
	}

	public T maxHealthyEatingIndexProduct() {
		T data = maximumElement(root);
		return data;
	}

	private T maximumElement(Node<T> root) {
		if (root == null) {
			return null;
		}
		T max = root.data;
		if (root.left != null) {
			T leftMax = (T) maximumElement(root.left);
			if (leftMax.compareTo(max) > 0) {
				max = leftMax;
			}
		}
		if (root.right != null) {
			T rightMax = (T) maximumElement(root.right);
			if (rightMax.compareTo(max) > 0) {
				max = rightMax;
			}
		}
		return (T) max;
	}

	public T minHealthyEatingIndexProduct() {
		return minimumElement(root);
	}

	private T minimumElement(Node<T> root) {
		if (root == null) {
			return null;
		}
		T min = root.data;
		if (root.left != null) {
			T leftMin = (T) minimumElement(root.left);
			if (leftMin.compareTo(min) < 0) {
				min = leftMin;
			}
		}
		if (root.right != null) {
			T rightMin = (T) minimumElement(root.right);
			if (rightMin.compareTo(min) < 0) {
				min = rightMin;
			}
		}
		return (T) min;
	}

	public void print() {
		printTree(root);
	}

	private void printTree(Node<T> node) {
		if (node == null)  // if the tree is empty  , then print nothing.
			return;

		System.out.println(node.data); // otherwise print the ccccccccccc
		printTree(node.left);
		printTree(node.right);
	}
}
