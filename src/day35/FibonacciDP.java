package day35;

public class FibonacciDP {


    // Recursive Solution
    public static int func(int n) {
        if(n <= 1) return n;
        return func(n-1) + func(n-2);
    }

    // Memoization
    // tc: O(n)
    // sc: o(n) + O(n)
    public static int func(int n, int[] dp) {
        if(n <= 1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = func(n-1, dp) + func(n-2, dp);
    }


    // tabulation
    // tc: O(n)
    // sc: O(n)
    public static int fibo(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // space optimization
    public static int fibonaaci(int n) {
        int prev1 = 1;
        int prev2 = 0;

        for(int i=2; i<=n; i++) {
            int curri = prev1 + prev2;
            prev2 = prev1;
            prev1 = curri;
        }

        return prev1;
    }
    public static void main(String[] args) {
        System.out.println(func(6));
        int[] dp = new int[7];
        for(int i=0; i<=6; i++) {
            dp[i] = -1;
        }
        System.out.println(func(6, dp));
        System.out.println(fibo(6));
        System.out.println(fibonaaci(6));
    }
}
