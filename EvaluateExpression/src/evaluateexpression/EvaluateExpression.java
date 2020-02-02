package evaluateexpression;

import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        // Check number of arguments passed
        if (args.length != 1) {
            System.out.println(
                    "Usage: java EvaluateExpression \"expression\"");
            System.exit(1);
        }

        try {
            System.out.println(evaluateExpression(args[0]));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Wrong expression: " + args[0]);
        }
    }

    /**
     * Evaluate an expression
     */
    public static int evaluateExpression(String expression) {
        // Create operandStack to store operands
        Stack<Integer> operandStack = new Stack<>();

        // Create operatorStack to store operators
        Stack<Character> operatorStack = new Stack<>();

        // Insert blanks around (, ), +, -, /, and *
        expression = insertBlanks(expression);

        // Extract operands and operators
        String[] tokens = expression.split(" ");

        // Phase 1: Scan tokens
        for (String token : tokens) {

          
            if (token.length() == 0) // Blank space
            {
                continue; // Back to the while loop to extract the next token
            } 
                                     
            else if (token.trim().charAt(0) == '(') {
                operatorStack.push('('); // Push '(' to stack
            } else if (token.trim().charAt(0) == ')') {
                // Process all the operators in the stack until seeing '('
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.pop(); // Pop the '(' symbol from the stack
            } 
            
            // Current token is an operator. 
            else if (token.charAt(0) == '+' || token.charAt(0) == '-' || 
                     token.charAt(0) == '*' || token.charAt(0) == '/' ||
                    token.charAt(0) == '^' || token.charAt(0) == '%' ) 
              { 
                // While top of 'ops' has same or greater precedence to current 
                // token, which is an operator. Apply operator on top of 'ops' 
                // to top two elements in values stack 
                while (!operatorStack.empty() && hasPrecedence(token.charAt(0), operatorStack.peek())) 
                    processAnOperator(operandStack, operatorStack);                  
                // Push current token to 'ops'. 
                 operatorStack.push(token.charAt(0));
            }                                               
            else { // An operand scanned
                // Push an operand to the stack
                operandStack.push(new Integer(token));
            }
          

        } // end of for loop 

        // Phase 2: process all the remaining operators in the stack 
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        // Return the result
        return operandStack.pop();
    }

    /**
     * Process one operator: Take an operator from operatorStack and apply it on
     * the operands in the operandStack
     */
    public static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+') {
            operandStack.push(op2 + op1);
        } else if (op == '-') {
            operandStack.push(op2 - op1);
        } else if (op == '*') {
            operandStack.push(op2 * op1);
        } else if (op == '/') {
            operandStack.push(op2 / op1);
        } else if (op == '%') {
            operandStack.push(op2 % op1);
        } else if (op == '^') {
            operandStack.push(Integer.valueOf((int) Math.pow(op2, op1)));
        }
    }

    public static String insertBlanks(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')'
                    || s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*' || s.charAt(i) == '/'
                    || s.charAt(i) == '^' || s.charAt(i) == '%') {
                result += " " + s.charAt(i) + " ";
            } else {
                result += s.charAt(i);
            }
        }

        return result;
    }
    
     // Returns true if 'op2' has higher or same precedence as 'op1', 
    // otherwise returns false. 
    public static boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/' || op1 == '%' || op1 == '^') && (op2 == '+' || op2 == '-')) 
            return false;
        if (( op1 == '^') && (op2 == '*' || op2 == '/' || op2 == '%')) 
            return false; 
        else
            return true; 
    } 
}
