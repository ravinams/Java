
public class StackTest {
	public static void main(String [] args)
	{
		Stack<StackNode> aStack = new StackImpl<StackNode>(2);
        
        System.out.println("Just created ArrayStack1 instance aStack.....empty");
        System.out.println("The stack contains: " + aStack.toString());
        
        System.out.println("Adding Enda using: aStack.push(\"{\")");
        aStack.push(new StackNode<String>("{"));
        System.out.println("The stack contains: " + aStack.toString());
   
        System.out.println("Adding Fred using: aStack.push(\"{\")");
        aStack.push(new StackNode<String>("{"));
        System.out.println("The stack contains: " + aStack.toString());

        System.out.println("Adding Ger using: aStack.push(\"}\")");
        aStack.push(new StackNode<String>("{"));
        System.out.println("The stack contains: " + aStack.toString());
        
        System.out.println("Removing the TOP element using: aStack.pop()");
        aStack.pop();
        System.out.println("The stack contains: " + aStack.toString());   
        
        System.out.println("Peek at the TOP element using: aStack.peek()");
        System.out.println("The TOP of the stack contains: \n" + aStack.peek()); 
		
	}
}
