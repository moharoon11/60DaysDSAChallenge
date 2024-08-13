package day20;

import java.util.ArrayList;

public class SubsetSumI {

    ArrayList<Integer> subsetSum(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> sumSubset = new ArrayList<>();
        func(arr, N, sumSubset, 0, 0);
        return sumSubset;
    }

    void func(ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset, int index, int sum) {

        if(index == N) {
            sumSubset.add(sum);
            return;
        }
        func(arr, N, sumSubset, index + 1, sum + arr.get(index));
        func(arr, N, sumSubset, index + 1, sum);
    }
}
