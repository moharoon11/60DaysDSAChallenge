package day23;

public class ValidParanthesisChecker {

    // Brute force approach
    // TC: O(3 ^ n)
    // SC: O(n)
    public boolean checkValidString(String s) {
        if(s.length() == 1) return false;
        return func(s, 0, 0);
    }

    public boolean func(String s, int index, int count) {

        if(count < 0) return false;

        if(index == s.length()) {
            return (count == 0);
        }

        if(s.charAt(index) == '(') {
            func(s, index + 1, count + 1);
        } else if(s.charAt(index) == ')') {
            func(s, index + 1, count - 1);
        }

        return (func(s, index + 1, count + 1) ||
                func(s, index + 1, count) ||
                func(s, index + 1, count - 1));
    }
}
