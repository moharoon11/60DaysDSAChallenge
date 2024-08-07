package day15;

import java.util.Stack;

public class SumOfSubArrayMinimum {


    // brute force solution
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        for(int i=0; i<arr.length; i++) {
            int min = arr[i];
            for(int j=i; j<arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum =  (sum + min) % mod;
            }
        }

        return sum;
    }

    // optimal solution

    public int sumSubarrayMins1(int[] arr) {
        long sum = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        int[] previousSmaller = previousSmallerIndex(arr);
        int[] nextSmaller = nextSmallerIndex(arr);

        for(int i=0; i<arr.length; i++) {
            int left = i - previousSmaller[i];
            int right = nextSmaller[i] - i;
            sum = (sum + ((long)right * left * arr[i]) % mod) % mod;
        }

        return (int) sum;
    }

    public int[] nextSmallerIndex(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] nextSmaller = new int[n];
        for(int i=n-1; i>=0; i--) {

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nextSmaller;
    }

    public int[] previousSmallerIndex(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] previousSmaller = new int[n];

        for(int i=0; i<n; i++) {

            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            previousSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return previousSmaller;
    }
}
