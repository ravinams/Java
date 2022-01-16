
public interface BinaryTree<T extends Comparable<T>> {
    
    public boolean isEmpty();
    public void add(T data);
    public int count();
    public T maxHealthyEatingIndexProduct();
    public T minHealthyEatingIndexProduct();
    public void print();
    
}
