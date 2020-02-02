/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oracle
 */
import java.util.Scanner;

public class InfixToPostfixConverter {

    public static void main(String[] args) {

        System.out.print("Enter a infix expression :");
        Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        System.out.println(convertToPostfix(exp));

    }

    static String convertToPostfix(String expression) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            //check if char is operator
            if (is0perator(c)) {
                while (stack.isEmpty() == false && precedence(c,stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            } else if (c == ')') {
                char x = stack.pop();
                while (x != '(') {
                    result += x;
                    x = stack.pop();
                }
            } else if (c == '(') {
                stack.push(c);
            } else { // oeprand 
                
                  result += c;
            }
        }
        
        
        for (int i = 0; i <= stack.size(); i++) {
            Character x = stack.pop();
          if (x !=null)
             result += x;
        }
      
        return result;

    }

     private static boolean is0perator(char c) {
         switch (c) {
            case '^':                
            case '*':
            case '/':                
            case '+':
            case '-':
                return true ;
            default:
                return false ;
        }      
    }

    private static int priority(char c) {
        switch (c) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }
    
      private static boolean precedence(char operator1 , char operator2 ) {
         return (priority(operator1) < priority(operator2) ) ;
    }

}
