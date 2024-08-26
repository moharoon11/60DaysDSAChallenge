package day30;

import java.util.*;

public class CountSubsetsWithSumK {

    public int perfectSum(int arr[],int n, int sum)
    {
        List<List<Integer>> list = getSubsets(arr, 0, new ArrayList<Integer>());
        int count = 0;
        for(List<Integer> part:list) {
            int addition = 0;
            for(int num:part) {
                addition += num;
            }
            if(addition == sum) count+=1;
        }
        return count;

    }

    public List<List<Integer>> getSubsets(int[] nums, int index, List<Integer> current) {
        List<List<Integer>> subsets = new ArrayList<>();
        if(index == nums.length) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(current));
            return list;
        }

        current.add(nums[index]);
        subsets.addAll(getSubsets(nums, index + 1, current));

        current.remove(current.size()-1);
        subsets.addAll(getSubsets(nums, index +1, current));

        return subsets;
    }

    // This is better compare to previous still TLE ERROR
    public int solve(int[] arr, int n, int index, int sum) {

        if(index == n) {
            if(sum == 0) {
                return 1;
            }
            return 0;
        }

        int count = 0;

        count += solve(arr, n, index+1, sum - arr[index]);
        count += solve(arr, n, index + 1, sum);
        return count;
    }


    // optimal solution will be using dynamic programming


}
