package day34.StringParanthesisProblems;

import java.util.*;

public class ValidParanthesis {

    public boolean isValid(String s) {
        if(s == null || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            char bracket = s.charAt(i);
            if(bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(bracket == ')' && top != '(') return false;
                if(bracket == ']' && top != '[') return false;
                if(bracket == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
