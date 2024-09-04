package day32;

import java.util.*;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3Method(int k, int n) {
        List<Integer> arr = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<List<Integer>> result = new ArrayList<>();
        helper1(arr, k, n, 0, new ArrayList<>(), result);
        return result;
    }

    void helper1(List<Integer> arr, int k, int n, int index, List<Integer> current, List<List<Integer>> result) {

        if(current.size() == k) {
            if(n == 0) {
                result.add(new ArrayList<>(current));
                return;
            }
            return;
        }

        if(index == arr.size() || n < 0) {
            return;
        }

        current.add(arr.get(index));
        helper1(arr, k, n - arr.get(index), index + 1, current, result);

        current.remove(current.size() - 1);
        helper1(arr, k, n, index + 1, current, result);
    }


    // another approach using recursion
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    void helper(int k, int n, int start, List<Integer> current, List<List<Integer>> result) {

        if (current.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        if (n < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            current.add(i);
            helper(k, n - i, i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
}
