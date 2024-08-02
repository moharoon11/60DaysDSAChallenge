package day13;

import java.util.Stack;

public class NearestSmallerElement {



    public static int[] findNearestSmaller(int[] arr, int n) {
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            boolean found = false;
            for(int j=i-1; j>=0; j--) {
                if(arr[j] < arr[i]) {
                    result[i] = arr[j];
                    found = true;
                    break;
                }
            }

            if(!found) result[i] = -1;
        }
        return result;
    }

    // monotonic stack approach
    public static int[] findNearestSmaller(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {

            while(!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return result;
    }
}
