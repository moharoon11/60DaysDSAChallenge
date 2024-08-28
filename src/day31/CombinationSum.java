package day31;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    public void helper(int[] candidate, int target, int index, List<Integer> current, List<List<Integer>> result) {

        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(index == candidate.length || target < 0) {
            return;
        }

        current.add(candidate[index]);
        helper(candidate, target - candidate[index], index, current, result);

        current.remove(current.size() - 1);
        helper(candidate, target, index + 1, current, result);
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
       //  Output is: [[2,2,3],[7]]
    }
}
