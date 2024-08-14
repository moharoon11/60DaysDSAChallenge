package day21;

public class MaxConsecutiveOnes {

    /**
     * BRUTE APPROACH
     * TIME COMPLEXITY: 0(n^2)
     * SPACE COMPLEXITY: O(1)
     */
    public static int findMaxOnesLen(int[] arr, int n, int k) {
        int maxLen = 0;

        for(int i=0; i<n; i++) {
            int zeros = 0;
            for(int j=i; j<n; j++) {
                if(arr[j] == 0) {
                    zeros++;
                }
                    if(zeros <= k) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    } else {
                        break;
                    }

            }
        }
        return maxLen;
    }


    /******************* OPTIMAL APPROACH USING SLIDING WINDOW ***********************/
    // TIME COMPLEXITY: O(n)
    // SPACE COMPLEXITY: O(1)
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, zeros = 0, maxLen = 0;

        while(right < nums.length) {
            if(nums[right] == 0) zeros++;

            if(zeros > k) {
                if(nums[left] == 0) zeros--;
                left++;
            }

            if(zeros <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }

        return maxLen;
    }
    public static void main(String[] args) {
       int[] arr = {1,1,1,1,0,0,0,1,1,0};
       System.out.println(findMaxOnesLen(arr, arr.length, 2));
    }


}
