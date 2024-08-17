package day23;

public class JumpGame {


    // TC: O(n)
    // SC: O(1)
    public boolean canJump(int[] nums) {
        int maxLen = 0;

        for(int i=0; i<nums.length; i++) {

            if(i > maxLen) return false;
            maxLen = Math.max(maxLen, i + nums[i]);
        }

        return true;
    }
}
