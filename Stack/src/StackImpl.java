
import java.util.Arrays;
public class StackImpl<T> implements Stack<T>{
	
	    private T items [];
	    private int maxSize;
	    private int top;
	    
	    public StackImpl(int size){
	        this.top = -1;
	        this.maxSize = size;
	        this.items = (T[]) new Object[maxSize];
	    }
	    
	    @Override
	    public void push(T elem) {
	        if (top == (maxSize - 1)){
	            if(top > 100){
	                throw new IndexOutOfBoundsException();
	            }
	        }
	        else{
	            reallocate();
	        }
	        top++;
	        items[top] = elem;
	    } 

	    @Override
	    public T pop() {
	        if(top < 0){
	            throw new IndexOutOfBoundsException();
	        }
	        else{
	            T elem = items[top];
	            top--;
	            return elem;
	        }
	    }

	    @Override
	    public T peek() {
	        if(top == -1){
	            System.out.println("Stack is empty");
	            throw new IndexOutOfBoundsException();
	        }
	        return items[top];
	    }

	    private void reallocate(){
	        maxSize *= 2; // mxS = mxS * 2
	        items = Arrays.copyOf(items, maxSize);
	    }
	    
	    @Override
	    public String toString() {
	        String str = "\nTOP";
	        int counter = top;
	        while(counter >= 0){
	            str += "\n" + items[counter];
	            counter--;
	        }
	        return str + "\nBOTTOM";      
	    }    

}
