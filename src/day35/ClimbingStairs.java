package day35;

public class ClimbingStairs {

    // recursive solution
    public int climbStairs(int n) {
        return func(n, 0);
    }

    public int func(int n, int index) {

        if(index > n) return 0;
        if(index == n) {
            return 1;
        }

        int l = func(n, index + 1);
        int r = func(n, index + 2);

        return l + r;
    }


    // recursive solution -> n as index
    public int func(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        return func(n -1) + func(n-2);
    }

    // memoization
    public static int func(int n, int[] dp) {
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = func(n-1, dp) + func(n-2, dp);
    }


    // tabulation
    public static int climb(int n) {
        if(n == 1 || n == 0) return 1;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // space optimization
    public static int function(int n) {
        if(n == 1 || n == 0) return 1;

        int prev1 = 1;
        int prev2 = 1;

        for(int i=2; i<=n; i++) {
            int curri = prev1 + prev2;
            prev2 = prev1;
            prev1 = curri;
        }

        return prev1;
    }


     public static void main(String[] args) {

     }


}
