package day36;

import java.util.HashSet;
import java.util.Set;

public class MaxSumNonAdjacentElements {


    // Recursive Approach
    public int rob(int[] arr) {
        return func(arr, arr.length-1);
    }

    public int func(int[] arr, int index) {

        if(index == 0) return arr[index];
        if(index < 0) return 0;

        int pick = arr[index] + func(arr, index - 2);
        int notPick = 0 + func(arr, index);

        return Math.max(pick, notPick);
    }

    // Memoization

    public static int func(int[] arr, int index, int[] dp) {

        if(index == 0 ) return arr[index];
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        int pick = arr[index] + func(arr, index - 2, dp);
        int notPick = 0 + func(arr, index -1, dp);

        return dp[index] = Math.max(pick, notPick);
    }

    //tabulation

    public int houseRob(int[] arr) {
        int[] dp = new int[arr.length];

        dp[0] = arr[0];

        for(int i=1; i<arr.length; i++) {
            int take = arr[i];
            if(i > 1) take += dp[i - 2];
            int notTake = 0 + dp[i - 1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[arr.length-1];
    }

    // space optimization
    public static int houseRobOptimized(int[] arr) {
        int prev1 = arr[0];
        int prev2 = 0;

        for(int i=1; i<arr.length; i++) {
            int take = arr[i];
            if(i > 1) take += prev2;
            int notTake = 0 + prev1;

            int curri = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curri;
        }

        return prev1;
    }

    public static void main(String... args) {

    }
}
