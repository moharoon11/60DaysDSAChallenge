package day13;

import java.util.Stack;

public class NextGreaterElement2 {

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        int[] previous = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            boolean found = false;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] > nums[i]) {
                    result[i] = nums[j];
                    previous[i] = nums[i];
                    found = true;
                    break;
                }
            }
            if(!found) {
                for(int p=0; p<previous.length; p++) {
                    if(nums[p] > nums[i]) {
                        result[i] = nums[p];
                        previous[i] = nums[i];
                        found = true;
                        break;
                    }
                }
            }

            if(!found) {
                result[i] = -1;
                previous[i] = nums[i];
            }

        }
        return result;
    }


    public int[] nextGreaterElements2(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;

        for(int i=0; i<nums.length; i++) {
            boolean found = false;
            for(int j=i+1; j <= i + n - 1; j++) {
                int index = j % n;
                if(nums[index] > nums[i]) {
                    result[i] = nums[index];
                    found = true;
                    break;
                }
            }
            if(!found) result[i] = -1;
        }

        return result;
    }


    // monotonic stack
    public int[] nextGreaterElementsUsingStack(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            if (i < n) {
                result[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(nums[i % n]);
        }

        return result;
    }
}
