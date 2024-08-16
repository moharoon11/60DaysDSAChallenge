package day22;

import java.util.List;
import java.util.ArrayList;

public class CoinChange {

    // TC: O(n)
    // SC: O(1) the ans list is required to return the answer apart we are not
    // using any extra space
    public static List<Integer> coinChange(int[] arr, int n, int value) {
        List<Integer> ans = new ArrayList<>();

        int i = n - 1;

        while(i >= 0) {

            if(arr[i] <= value) {
                value -= arr[i];
                ans.add(arr[i]);
                if(value == 0) break;
            } else  {
                i--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr= {1,2,5,10,20,50, 100, 500, 1000};
        System.out.println(coinChange(arr, arr.length, 87));
    }

}
