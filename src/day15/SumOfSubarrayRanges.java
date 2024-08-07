package day15;

import java.util.Stack;

public class SumOfSubarrayRanges {

    public long subArrayRanges(int[] nums) {

        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            int largest = nums[i];
            int smallest = nums[i];
            for(int j=i+1; j<nums.length; j++) {
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);
                sum += largest - smallest;
            }
        }
        return sum;
    }

    // using stacks
    public long subArrayRanges1(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public long sumSubarrayMins(int[] arr) {
        long sum = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        int[] previousSmaller = previousSmallerIndex(arr);
        int[] nextSmaller = nextSmallerIndex(arr);

        for (int i = 0; i < arr.length; i++) {
            int left = i - previousSmaller[i];
            int right = nextSmaller[i] - i;
            long product = ((long) right * left % mod) * arr[i] % mod;
            sum = (sum + product) % mod;
        }

        return sum;
    }

    public int[] nextSmallerIndex(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] nextSmaller = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nextSmaller;
    }

    public int[] previousSmallerIndex(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] previousSmaller = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            previousSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return previousSmaller;
    }

    public long sumSubarrayMaxs(int[] arr) {
        long sum = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        int[] previousLarger = previousLargerIndex(arr);
        int[] nextLarger = nextLargerIndex(arr);

        for (int i = 0; i < arr.length; i++) {
            int left = i - previousLarger[i];
            int right = nextLarger[i] - i;
            long product = ((long) right * left % mod) * arr[i] % mod;
            sum = (sum + product) % mod;
        }

        return sum;
    }

    public int[] nextLargerIndex(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] nextLarger = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            nextLarger[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nextLarger;
    }

    public int[] previousLargerIndex(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] previousLarger = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            previousLarger[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return previousLarger;
    }

}
