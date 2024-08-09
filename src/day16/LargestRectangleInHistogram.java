package day16;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleAreaBrute(int[] heights) {

        int max = Integer.MIN_VALUE;

        for(int i=0; i<heights.length; i++) {

            int right = i + 1;
            int left = i - 1;
            int height = heights[i];
            int width = 1;
            while(right < heights.length && heights[right] >= heights[i]) {
                right += 1;
                width += 1;
            }

            while(left >= 0 && heights[left] >= heights[i]) {
                left -= 1;
                width += 1;
            }
            max = Math.max(max, height * width);
        }
        return max;
    }

    // using stacks
    public int largestRectangleArea(int[] heights) {

        int pse[] = previousSmaller(heights);
        int nse[] = nextSmaller(heights);
        int max = Integer.MIN_VALUE;

        for(int i=0; i<heights.length; i++) {
            max = Math.max(max, heights[i] * (nse[i] - pse[i] -1));
        }

        return max;
    }

    public int[] nextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];

        for(int i=n-1; i>=0; i--) {

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }

    public int[] previousSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] pse = new int[n];

        for(int i=0; i<n; i++) {

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pse;
    }
}
