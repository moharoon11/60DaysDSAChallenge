package day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSubsequence {

    public static void printSubsequence(int[] arr) {
        helper(0, new ArrayList<Integer>(), arr, arr.length);
    }

    public static void helper(int index, List<Integer> list, int[] arr, int n) {
        if(index >= n) {
            if(!list.isEmpty())
              System.out.println(list);
            return;
        }

        list.add(arr[index]);
        helper(index + 1, list, arr, n);
        list.remove(list.size() - 1);
        helper(index + 1, list, arr, n);
    }

    public static void main(String[] args) {
       int[] arr = {3, 2, 1};
       printSubsequence(arr);
    }
}
