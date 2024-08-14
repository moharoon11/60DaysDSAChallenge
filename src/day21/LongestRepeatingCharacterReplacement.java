package day21;

public class LongestRepeatingCharacterReplacement {


    // BRUTE APPROACH
    // TC: O(n ^ 2)
    // SC: O(26)
    public static int func(String s, int n, int k) {
        int maxLen = 0;

        for(int i=0; i<n; i++) {
            int[] hash = new int[26];
            int maxFreq = 0;
            for(int j=i; j<n; j++) {
                hash[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, hash[s.charAt(j)- 'A']);
                int changes = (j - i + 1) - maxFreq;
                if(changes <= k) maxLen = Math.max(maxLen, j - i + 1);
                else break;
            }
        }
        return maxLen;
    }



    /******************** OPTIMAL APPROACH USING SLIDING WINDOW ***********************/
    // TC: O(n)
    // SC: O(26)
    public static int getLength(String s, int k) {
    int left = 0;
    int right = 0;
    int maxLen = 0;
    int maxF = 0;
    int[] hash = new int[26];

        while (right < s.length()) {
        // Increment the count of the character at the 'right' position.
        hash[s.charAt(right) - 'A']++;
        // Update the max frequency in the current window.
        maxF = Math.max(maxF, hash[s.charAt(right) - 'A']);

        // If the current window size minus the max frequency is greater than k,
        // this means we need to shrink the window.
        if ((right - left + 1) - maxF > k) {
            // Decrement the count of the character at the 'left' position.
            hash[s.charAt(left) - 'A']--;
            // Move the left pointer to the right.
            left++;
        }

        // Update the maximum length of the substring.
        maxLen = Math.max(maxLen, right - left + 1);

        // Move the right pointer to the right.
        right++;
    }

        return maxLen;
   }

    public static void main(String[] args) {

    }

}
