package day21;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * BRUTE APPROACH
     * TIME COMPLEXITY: O(n ^ 2)
     * SPACE COMPLEXITY: O(256)
     */
    public static int findLength(String str) {
        int len = 0;
        int maxLen = Integer.MIN_VALUE;

        for(int i=0; i<str.length(); i++) {
            int[] hash = new int[256];
            for(int j=i; j<str.length(); j++) {
                if(hash[str.charAt(j)] == 1) break;
                len = j - i + 1;
                maxLen = Math.max(len, maxLen);
                hash[str.charAt(j)] = 1;
            }
        }

        return maxLen;
    }


    /************** OPTIMAL APPROACH USING SLIDING WINDOW *********************/
    // TIME COMPLEXITY: O(n)
    // SPACE COMPLEXITY: O(n)
    public static int findMaxLength(String s) {
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0, right = 0, n = s.length();

        while(right < n) {

            if(map.containsKey(s.charAt(right))) {
                if(left <= map.get(s.charAt(right))) {
                    left = map.get(s.charAt(right)) + 1;
                }
            }

            maxLen = Math.max(maxLen, right - left + 1);
            map.put(s.charAt(right), right);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
       String s = "cadbzacbd";
       System.out.println(findMaxLength(s));
    }

}
