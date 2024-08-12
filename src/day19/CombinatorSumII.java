package day19;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinatorSumII {

    public void func(int[] arr, int index, int target, List<List<Integer>> ans, List<Integer> temp) {
        if(target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }


        for(int i=index; i<arr.length; i++) {
            if(i > index && arr[i - 1] == arr[i]) continue;
            if(arr[i] > target) break;

            temp.add(arr[i]);
            func(arr, i + 1, target - arr[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        func(candidates, 0, target, ans, temp);
        return ans;
    }
}
