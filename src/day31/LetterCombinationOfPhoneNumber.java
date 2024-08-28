package day31;

import java.util.*;

public class LetterCombinationOfPhoneNumber {

    private static final String[] KEYPAD = {
            "",    // 0
            "",    // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz" // 9
    };

    public List<String> letterCombinations(String digits) {
        // Return an empty list if the input is empty
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return func(digits, "");
    }

    public List<String> func(String digits, String ans) {
        // Base case: if no more digits are left, add the current combination to the list
        if (digits.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        List<String> result = new ArrayList<>();
        int digit = digits.charAt(0) - '0';
        String letters = KEYPAD[digit];
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            result.addAll(func(digits.substring(1), ans + ch));
        }

        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
    }
}
