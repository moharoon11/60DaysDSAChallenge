package day30;

import java.util.*;

public class GenerateSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        return getSubsets(nums, 0, new ArrayList<Integer>());
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

    }
}
