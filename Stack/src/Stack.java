// Stack iterface
public interface Stack<T> {
	
	 //Adding an element
    public void push(T e);
    
    //Removing an element
    public T pop();

    // Viewing the top element
    public T peek();
    
    // return the String representation of Stack
    public String toString() ;

}
