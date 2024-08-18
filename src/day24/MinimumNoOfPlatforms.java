package day24;

import java.util.Arrays;

public class MinimumNoOfPlatforms {

    // Brute force approach
    // TC: O(n)
    // SC: O(1)
    static int findPlatform(int arr[], int dep[], int n)
    {
        int ans = 1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            int count = 1;
            for(int j=i+1; j<arr.length; j++) {
                if((arr[i] >= arr[j] && arr[i] <= dep[j]) ||
                        (arr[j] >= arr[i] && arr[j] <= dep[i])
                ) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    // Greedy approach
    // TC: O(2(n log n)) + O(2n)
    // SC: O(1)
    static int findPlatformGreedy(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int max = 0;
        int count = 0;
        int i = 0, j = 0;
        while(i < arr.length && j < dep.length) {

            if(arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }

            max = Math.max(max, count);
        }

        return max;
    }


    // Without changing the given arrays
    // TC: O(2(n log n)) + O(2n)
    // SC: O(2n)
    public static int findPlatformRequired(int[] arr, int[] dep, int n) {
        int[] arrCpy = Arrays.copyOf(arr, n);
        int[] depCpy = Arrays.copyOf(dep, n);

        Arrays.sort(arrCpy);
        Arrays.sort(depCpy);

        int max = 0;
        int count = 0;
        int i = 0, j = 0;
        while(i < arr.length && j < dep.length) {

            if(arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }

            max = Math.max(max, count);
        }

        return max;
    }


    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        int ans1 = findPlatform(arr, dep, arr.length);
        int ans2 = findPlatformGreedy(arr, dep, arr.length);
        int ans3 = findPlatformRequired(arr, dep, arr.length);

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}
