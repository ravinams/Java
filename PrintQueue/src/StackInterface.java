public interface StackInterface<E>
{
   public void push(E x); //places x on a stack
   public E pop(); // removes and returns the top item or null if the stack is empty
   public boolean isEmpty(); // returns true if no elements are on the stack
   public E peek(); // returns the top item or null if empty, does not alter the stack
   public int size(); // returns the number of items on the stack
}
