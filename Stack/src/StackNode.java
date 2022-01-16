
// Stack Node 
public class StackNode<T> {	
	T data ;
	public StackNode(T d)
	{
		data = d  ;
	}	
	
	@Override
    public String toString()
    {
    	return String.valueOf(data) ;
    }
}
