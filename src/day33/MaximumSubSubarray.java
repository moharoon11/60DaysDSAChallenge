package day33;

public class MaximumSubSubarray {


    public static int getMaxSum(int[] arr, int k, int n) {
        int maxSum = Integer.MIN_VALUE;

        int start  = 0;
        int end = 0;
        int sum = 0;
        while(end < n) {
            sum += arr[end];

            if(end - start + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[start];
                start++;
            }

            end++;
        }

        return maxSum;
    }


    public static void main(String... args) {
        int[] arr = {1,1,1,1,1,1,3};
        System.out.println(getMaxSum(arr, 3, arr.length));
    }
}
