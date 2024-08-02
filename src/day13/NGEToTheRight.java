package day13;

import java.util.Stack;

public class NGEToTheRight {
    public static int[] countGreaterElementsToTheRight(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that are not greater than the current element
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            // The size of the stack is the number of greater elements to the right
            result[i] = stack.size();
            // Push the current element to the stack
            stack.push(nums[i]);
        }

        return result;
    }
}
