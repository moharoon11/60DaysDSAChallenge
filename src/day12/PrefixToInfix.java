package day12;

import java.util.Stack;

public class PrefixToInfix {

    public static String convert(String s) {
        int i=s.length() - 1;
        Stack<String> stack = new Stack<String>();

        while(i >= 0) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                stack.push("" + c);
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();
                String convertedString = "(" + top1 + c + top2 + ")";
                stack.push(convertedString);
            }
            i--;
        }
        return stack.pop();
    }
}
