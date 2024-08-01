package day12;

import java.util.Stack;

public class PostfixToPrefix {

    public static String convert(String s) {
        int i = 0;
        Stack<String> stack = new Stack<>();

        while(i < s.length()) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                stack.push("" + c);
            } else {
                String top1 =  stack.pop();
                String top2 = stack.pop();
                String convertedString = c + top1 + top2;
                stack.push(convertedString);
            }
            i++;
        }
        return stack.pop();
    }

}
