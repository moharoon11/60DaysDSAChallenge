package day30;

public class GenerateBinaryStringSizeKWIthoutConsecutiveOnes {


    public static void printBinaryStrings(int k) {
        helper(k, "0");
        helper(k, "1");
    }

    public static void helper(int k, String s) {
        if(s.length() == k) {
            System.out.println(s);
            return;
        }

        if(s.charAt(s.length()-1) == '0') {
            helper(k, s + "0");
            helper(k, s + "1");
        } else if(s.charAt(s.length() - 1) == '1') {
            helper(k, s + "0");
        }

    }

    public static void main(String[] args) {
         printBinaryStrings(3);
    }
}
