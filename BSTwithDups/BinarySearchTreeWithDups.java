import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = newEntry;
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
		} else {
			addEntryHelperNonRecursive(newEntry);
		}
		return result;
	}
	
	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	private void addEntryHelperNonRecursive(T newEntry) {
     	  BinaryNode<T> currentNode = getRootNode();
       
      
       boolean found = false;
       boolean looking = false;
       while (!found) {
           T currentEntry = currentNode.getData();
           int comparison = newEntry.compareTo(currentEntry);

        if (comparison <= 0) { // currentEntry is less or equal than newEntry, in other words newEntry is smaller
               if (currentNode.hasLeftChild())
                   currentNode = currentNode.getLeftChild();
               else {
                   found = true;
                   currentNode.setLeftChild(new BinaryNode<T>(newEntry));
               } // end if
           } else {// currentEntry is smaller than newEntry
              

               if (currentNode.hasRightChild())
                   currentNode = currentNode.getRightChild();
               else {
                   found = true;
                   currentNode.setRightChild(new BinaryNode<T>(newEntry));
               }
           }
       }

      
		
	}


	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countEntriesNonRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> currentNode = getRootNode();

	    boolean found = false;

	    Queue<BinaryNode<T>> queue = new LinkedList(); 
	    queue.add(currentNode) ;

		// consider a loop!
		 while (!queue.isEmpty()) {

          BinaryNode<T> temp = queue.poll(); 
            if (target.compareTo(temp.getData()) == 0 )
            count++; 
  
            // Enqueue left child  
            if (temp.hasLeftChild())  
            { 
                queue.add(temp.getLeftChild()); 
            } 
  
            // Enqueue right child  
            if (temp.hasRightChild() )  
            { 
                queue.add(temp.getRightChild()); 
            } 
          }
		return count;
	}

	// YOUR CODE HERE! MUST BE RECURSIVE! YOU ARE ALLOWED TO CREATE A PRIVATE HELPER.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		
		count = countGreaterRecursiveHeler(rootNode, target) ;
		
		return count;
	}

	public int countGreaterRecursiveHeler(BinaryNode<T> node , T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int cnt = 0 ;
		if (node !=null )
		{
		  if ( target.compareTo(node.getData()) < 0 )
			   cnt  = 1  ;
	      return cnt + countGreaterRecursiveHeler(node.getLeftChild(),target) +  countGreaterRecursiveHeler(node.getRightChild(),target);		  
		}
		return cnt ;
		
	}
		
	// YOUR CODE HERE! MUST USE A STACK!! MUST NOT BE RECURSIVE! 
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterWithStack(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
		nodeStack.push(rootNode);
		while(!nodeStack.isEmpty())
		{
          BinaryNode<T> temp = nodeStack.pop();

          if (target.compareTo(temp.getData()) < 0 )
          	  count++ ;

         
          if (temp.hasLeftChild())
          	  nodeStack.push(temp.getLeftChild()) ; 

           if (temp.hasRightChild())
          	  nodeStack.push(temp.getRightChild()) ; 
		}

		// consider a loop based on the stack!
		return count;
	}
		
	// YOUR EXTRA CREDIT CODE HERE! THIS METHOD MUST BE O(n). 
	// YOU ARE ALLOWED TO USE A HELPER METHOD. THE METHOD CAN BE ITERATIVE OR RECURSIVE. 
	public int countUniqueValues() {
		List<BinaryNode<T>> list = new ArrayList();
		BinaryNode<T> node = getRootNode() ;		
		countUniqueValuesHelper(node , list);		
		return list.size();
	}
	
	private void countUniqueValuesHelper(BinaryNode<T> node , List<BinaryNode<T>> uniqueList) {
		 if (node !=null)
		 	 {
		 	  if (!isAlreaadyAdded(uniqueList,node.getData()))
		 	        uniqueList.add(node) ;
              if (node.hasLeftChild())
              	 countUniqueValuesHelper(node.getLeftChild(),uniqueList) ;
              if (node.hasRightChild())
              	 countUniqueValuesHelper(node.getRightChild(),uniqueList) ;
		 	 }		
	}
    private boolean isAlreaadyAdded(List<BinaryNode<T>> uniqueList , T target)
    {
      for (BinaryNode<T> temp:uniqueList)
      	  if (target.compareTo(temp.getData())==0)
                 return true ;
      return false ;
    }
	
	public int getLeftHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}
	


}