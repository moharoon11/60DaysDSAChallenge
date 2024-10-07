package day35;

import java.util.Arrays;

public class FrogJump {


    // recursive approach
    public int minimumEnergyRecursive(int arr[],int N){
        return func(arr, N, 0, 0);
    }

    public static int func(int arr[], int n, int index, int energy) {

        if(index == n-1) {
            return energy;
        }

        int jump1 = func(arr, n, index + 1, energy + Math.abs(arr[index] - arr[index + 1]));
        int jump2 = Integer.MAX_VALUE;
        if(index < n - 2) {
            jump2 = func(arr, n, index + 2, energy + Math.abs(arr[index] -  arr[index + 2]));
        }

        return Math.min(jump1, jump2);
    }

    // recursive approach
    public static int f(int index, int[] arr) {
        if(index == 0) return 0;

        int left = f(index - 1, arr) + Math.abs(arr[index - 1] - arr[index]);
        int right = Integer.MAX_VALUE;
        if(index > 1) {
            right = f(index - 2, arr) + Math.abs(arr[index - 2] - arr[index]);
        }

        return Math.min(left, right);
    }

    // Memoization
    public int minimumEnergyMemoization(int arr[],int N){
        int[] dp = new int[N];
        // Initialize the dp array with -1 to indicate uncomputed values
        Arrays.fill(dp, -1);

        // Call the memoized function starting from the last stone
        return f(N - 1, arr, dp);
    }


    public static int f(int index, int[] arr, int[] dp) {
        if(index == 0) return 0;

        if(dp[index] != -1) return dp[index];

        int left = f(index - 1, arr, dp) + Math.abs(arr[index - 1] - arr[index]);
        int right = Integer.MAX_VALUE;
        if(index > 1) {
            right = f(index - 2, arr, dp) + Math.abs(arr[index - 2] - arr[index]);
        }

        return dp[index] = Math.min(left, right);
    }
}
