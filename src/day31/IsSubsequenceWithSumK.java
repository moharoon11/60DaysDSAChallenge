package day31;

public class IsSubsequenceWithSumK {


    // Recursive Solution TLE ERROR
    public static boolean isSubsetPresent(int n, int k,int []a) {
        return solve(a, n, k, 0);
    }

    public static boolean solve(int[] arr, int n, int sum, int index) {

        if(sum == 0) return true;

        if(index == n) return false;

        return (solve(arr, n, sum - arr[index], index + 1) || solve(arr, n, sum, index + 1));
    }

    public static void main(String[] args) {
        int n = 3, k = 5;
        int[] arr = {1, 2, 3};
    }

    // Optimal approach will be using dynamic programming
}
