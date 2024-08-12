package day18;

import java.util.ArrayList;
import java.util.List;


public class GivenSumSubSequence {

    public static void printSequence(int[] arr, int n, int sum) {
        helper(0, new ArrayList<Integer>(), 0, arr, n, sum);
    }

    public static void helper(int index, List<Integer> list, int addedSum, int[] arr, int n, int sum) {
        if(index >= n) {
            if(addedSum == sum) {
                System.out.println(list);
            }
            return;
        }

        list.add(arr[index]);
        addedSum += arr[index];
        helper(index + 1, list, addedSum, arr, n, sum);
        list.remove(list.size() - 1);
        addedSum -= arr[index];
        helper(index + 1, list, addedSum, arr, n, sum);
    }

    public static void printAnyOneSequence(int[] arr, int n, int sum) {
        helper1(0, new ArrayList<Integer>(), 0, arr, n, sum);
    }

    public static boolean helper1(int index, List<Integer> list, int addedSum, int[] arr, int n, int sum) {
        if(index >= n) {
            if(addedSum == sum) {
                System.out.println(list);
                return true;
            }
            return false;
        }

        list.add(arr[index]);
        addedSum += arr[index];
        if(helper1(index + 1, list, addedSum, arr, n, sum)) return true;

        list.remove(list.size() - 1);
        addedSum -= arr[index];
        if(helper1(index + 1, list, addedSum, arr, n, sum)) return true;

        return false;
    }

    public static int countSubsequenceSum(int[] arr, int n, int sum) {
        return helperCount(0, 0, arr, n, sum);
    }

    public static int helperCount(int index, int addedSum, int[] arr, int n, int sum) {
        if(index >= n) {
            if(addedSum == sum) {
                return 1;
            }
            return 0;
        }


        addedSum += arr[index];
        int left = helperCount(index + 1, addedSum, arr, n, sum);


        addedSum -= arr[index];
        int right = helperCount(index + 1, addedSum, arr, n, sum);

        return left + right;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int sum = 2;
        int n = arr.length;
        printSequence(arr, n, sum);
       // printAnyOneSequence(arr, n, sum);
        System.out.println(countSubsequenceSum(arr, n, sum));
    }
}
