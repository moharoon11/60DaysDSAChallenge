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

    // this is the better approach without using dp
    // but it is not working in gfg
    public int perfectSum1(int arr[], int n, int sum) {
        return countSubsets1(arr, n, sum, 0);
    }

    public static int countSubsets1(int[] arr, int n, int sum, int index) {
        // Base Cases
        if (sum == 0) {
            return 1; // One valid subset (the empty subset) that sums to zero
        }
        if (index >= n) {
            return 0; // No subset can sum to the target if there are no elements left
        }

        // If the current element is greater than the sum, ignore it
        if (arr[index] > sum) {
            return countSubsets1(arr, n, sum, index + 1);
        }

        // Return the sum of the count of subsets that include the current element
        // and the count of subsets that exclude the current element
        return countSubsets1(arr, n, sum, index + 1) // Exclude current element
                + countSubsets1(arr, n, sum - arr[index], index + 1); // Include current element and move to the next index
    }
}
