package day11;

import java.util.Stack;

public class InfixToPostfix {


    public static int prec(char ch) {
        switch(ch) {
            case '+' :
            case '-' :
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }

        return -1;
    }

    public static String infixToPostfix(String s) {

        String result = new String("");

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c=='(') {
                stack.push('(');
            } else if (c == ')') {
                while(!stack.isEmpty() && stack.peek() != ')') {
                    result += stack.pop();
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        while(!stack.isEmpty()) {
            if(stack.peek() == '(') {
                return "Invalid Expression";
            }
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Prefix expression: " + infixToPostfix(exp));
    }
}
