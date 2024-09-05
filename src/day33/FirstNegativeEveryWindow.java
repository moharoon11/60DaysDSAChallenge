package day33;

import java.util.*;

public class FirstNegativeEveryWindow {


    public static List<Integer> firstNegative(int[] arr, int n, int k) {
        List<Integer> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        int start = 0;
        int end = 0;

        while(end < n) {

            if(arr[end] < 0) {
                temp.add(arr[end]);
            }

            if(end - start + 1 < k) {
                end++;
            } else if(end - start + 1 == k) {
                if(temp.isEmpty()) {
                    result.add(0);
                } else {
                    result.add(temp.getFirst());

                    if(arr[start] == temp.getFirst()) {
                        temp.removeFirst();
                    }
                }
                start++;
                end++;
             }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
