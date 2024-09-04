package day32;

import java.util.ArrayList;

public class SubSetSumI {


    // brute force approach
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {

        ArrayList<ArrayList<Integer>> subsets = generateSubsets(arr, n, 0, new ArrayList<>());
        ArrayList<Integer> answer =  new ArrayList<>();
        for(ArrayList<Integer> part : subsets) {
            int sum = 0;
            for(int num:part) {
                sum += num;
            }
            answer.add(sum);
        }

        return answer;
    }

    ArrayList<ArrayList<Integer>> generateSubsets(ArrayList<Integer> arr, int n, int index, ArrayList<Integer> current) {


        if(index == n) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(current));
            return list;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        current.add(arr.get(index));
        result.addAll(generateSubsets(arr, n, index + 1,current));

        current.remove(current.size() - 1);
        result.addAll(generateSubsets(arr, n, index + 1, current));

        return result;
    }

    // better approach
    ArrayList<Integer> subsetSumsI(ArrayList<Integer> arr, int n) {
        return helper(arr, n, 0, 0);
    }

    ArrayList<Integer> helper(ArrayList<Integer> arr, int n, int index, int sum) {


        if(index == n) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(sum);
            return list;
        }

        ArrayList<Integer> result = new ArrayList<>();

        result.addAll(helper(arr, n, index + 1, sum + arr.get(index)));
        result.addAll(helper(arr, n, index + 1, sum));

        return result;
    }
}
