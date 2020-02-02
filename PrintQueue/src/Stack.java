import java.util.ArrayList; 
class Stack<E> implements StackInterface<E>
{
	private ArrayList<E> items;
	public Stack() // default constructor creates an empty stack 
	{
		items = new ArrayList<E>(); 
	}
	public Stack(int initialCapacity) // one argument constructor, creates a stack with initial capacity initialCapacity 
	{
		items = new ArrayList<E>(initialCapacity); 
	}
	public void push(E x) // uses the ArrayList method add(E o)
	{
		items.add(x);
	}
	public E pop()
	{
		if (isEmpty())
			return null;
		return items.remove(items.size() -1);
	}
	public boolean isEmpty() // uses the ArrayList method isEmpty()
	{
		return items.isEmpty();
	}
	public int size()
	{
		return items.size();
	}
	public E peek()
	{
		if (isEmpty())
			return null;
		return items.get(items.size()-1);
	}
}
