package day32;

import java.util.*;

public class SubSetSumII {

    public void func(int index, int[] arr, List<List<Integer>> list, List<Integer> path) {
        list.add(new ArrayList<>(path));

        for(int i=index; i<arr.length; i++) {
            if(i != index && arr[i - 1] == arr[i]) continue;
            path.add(arr[i]);
            func(i + 1, arr, list, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        func(0, nums, list, path);
        return list;
    }


}
