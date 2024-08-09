package day16;

import java.util.List;
import java.util.ArrayList;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++) {
            int max = nums[i];
            if(nums.length - i < k) break;
            for(int j=i; j<i+k; j++) {
                max = Math.max(max, nums[j]);
            }
            result.add(max);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
