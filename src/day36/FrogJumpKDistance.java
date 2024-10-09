package day36;

public class FrogJumpKDistance {

    // Recursive approach
    public int jump(int k, int arr[]) {
        return func(arr, arr.length-1, k);
    }

    public static int func(int[] arr, int index, int k) {
        if(index == 0) return 0;

        int minEnergy = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++) {
            if(index - j >= 0) {
                int jumpEnergy = Math.abs(arr[index] - arr[index - j]) + func(arr, index - j, k);
                minEnergy = Math.min(minEnergy, jumpEnergy);
            }
        }

        return minEnergy;
    }


    // Memoization approach
    public static int jumpMemoization(int[] arr, int k) {
        int[] dp = new int[arr.length];
        return funcMemoization(arr, arr.length - 1, k, dp);
    }

    public static int funcMemoization(int[] arr, int index, int k, int[] dp) {

        if(index == 0) return 0;
        if(dp[index] != 0) return dp[index];

        int minEnergy = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++) {
            if(index - j >= k) {
                int jumpEnergy = Math.abs(arr[index] -  arr[index - j]) + funcMemoization(arr, index - j, k, dp);
                minEnergy = Math.min(jumpEnergy, minEnergy);
            }
        }

        return dp[index] = minEnergy;
    }

    // Tabulation approach
    public static int funcTabulation(int[] arr, int index, int k, int[] dp) {
        dp[0] = 0;


        for(int i=1; i<=index; i++) {
            int minimum = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++) {
                if(i - j >= 0) {
                    int total = dp[i - j] + Math.abs(arr[i] - arr[i-j]);
                    minimum = Math.min(minimum, total);
                }
            }
            dp[i] = minimum;
        }

        return dp[index];
    }




    public static void main(String[] args) {

    }
}
