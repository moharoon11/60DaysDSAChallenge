package day11;

import java.util.Stack;

public class InfixToPrefix {

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

    public static String reverse(String s) {
        StringBuilder result = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch == '(') {
                result.append(')');
            } else if(ch == ')') {
                result.append('(');
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String infixToPrefix(String s) {

        s = reverse(s);

        int i=0;
        Stack<Character> stack = new Stack<Character>();
        String ans = String.valueOf("");

        while(i < s.length()) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                ans += c;
            } else if(c == '(') {
                stack.push(c);
            } else if(c == ')') {

                while(!stack.isEmpty() && stack.peek() != '(') {
                    ans = ans + stack.pop();
                }
                stack.pop();
            } else {
                if(c == '^') {
                    while(!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
                        ans += stack.pop();
                    }
                } else {
                    while(!stack.isEmpty() && prec(c) < prec(stack.peek())) {
                        ans += stack.pop();
                    }
                }
                stack.push(c);
            }
            i++;
        }

        while(!stack.isEmpty()) {
            ans += stack.pop();
        }
        ans = reverse(ans);

        return ans;
    }
}
