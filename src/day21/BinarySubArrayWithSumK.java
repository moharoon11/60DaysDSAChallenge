package day21;


public class BinarySubArrayWithSumK {

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

            sum += nums[right];

            while(sum > goal) {
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}
