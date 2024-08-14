package day21;

public class CountNiceSubarrays {

    // sliding window optimized solution
    // TC: O(2 x 2n)
    // SC: O(1)
    public int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums, goal) - func(nums, goal - 1);
    }

    // TC: O(2n)
    public int func(int[] nums, int goal) {
        if(goal < 0) return 0;
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while(right < nums.length) {

            sum += nums[right] % 2;

            while(sum > goal) {
                sum -= nums[left] % 2;
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}
