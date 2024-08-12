package day18;

public class PallindromeStringRecursion {

    public static boolean isPallindrome(String word) {
        return helper(word, 0, word.length() -  1);
    }

    public static boolean helper(String word, int left, int right) {
        if(left > right) return true;

        if(word.charAt(left) == word.charAt(right)) {
             return helper(word, left + 1, right - 1);
        }

        return false;
    }

    public static boolean helperOnePointer(String word, int left) {
        int n = word.length();
        int mid = n / 2;
        if(left > mid) return true;

        if(word.charAt(left) == word.charAt(n - 1 - left)) {
            return helperOnePointer(word, left + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        String madam = "madam";
        String hello = "hello";
        System.out.println(isPallindrome(madam));
        System.out.println(isPallindrome(hello));
    }
}
