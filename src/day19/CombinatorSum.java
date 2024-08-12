package day19;

import java.util.List;
import java.util.ArrayList;

public class CombinatorSum {
    public static void func(int[] arr, int index, int target, List<Integer> temp, List<List<Integer>> ans) {

        if(index == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(arr[index] <= target) {
            temp.add(arr[index]);
            func(arr, index, target - arr[index], temp, ans);
            temp.remove(temp.size() - 1);
        }

        func(arr, index + 1, target, temp, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        func(candidates, 0, target, temp, ans);
        return ans;
    }
}
