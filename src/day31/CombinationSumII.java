package day31;

import java.util.*;

public class CombinationSumII {

    public void helper(int[] arr, int target, int index, List<Integer> current, List<List<Integer>> result) {

        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }


        for(int i=index; i<arr.length; i++) {
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            current.add(arr[i]);
            helper(arr, target - arr[i], i+1, current, result);

            current.remove(current.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5}; int target = 8;
       // Output is:
        //[
         //[1,1,6],
        //[1,2,5],
        //[1,7],
        //[2,6]
       //]
    }
}
