
public class BinaryTreeTest {
	
	public static void main(String [] args)
	{
	FoodProduct fp = null ;
	BinaryTree<FoodProduct> tree = new BinaryTreeImpl<FoodProduct>();
	
	// Node<FoodProduct> node = new Node<FoodProduct>(new FoodProduct("Biscut",20f,1))
	
	System.out.println( "is Empty : "+tree.isEmpty());
	
	tree.add(new FoodProduct("Chocolate",15f,10)) ;
	tree.add(new FoodProduct("Bread",25f,5)) ;
	tree.add(new FoodProduct("Biscut",20f,1)) ;
	
	tree.print(); 
	
	System.out.println( "is Empty : "+tree.isEmpty());
	System.out.println( "count : "+tree.count());
	System.out.println( "least healthy : "+tree.maxHealthyEatingIndexProduct());
	System.out.println( "most healthy  : "+tree.minHealthyEatingIndexProduct());
	
	}
	
}
