
public class Node<T extends Comparable<T>> {
	
	    public T data;	    	   	    
	    public Node left;
	    public Node right;
	    
	    public Node() {
	    	left = right = null ;
	    }
	    public Node(T d) {
	    	data  = d ;
	    	left = right = null ;
	    }
	    	    
}
