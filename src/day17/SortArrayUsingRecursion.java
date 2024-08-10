package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayUsingRecursion {


    public static void sortUsingRecursion(List<Integer> list) {

        if(list.size() == 1) return;

        int temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        sortUsingRecursion(list);
        insert(list, temp);
    }

    public static void insert(List<Integer> list, int temp) {

        if(list.isEmpty() || list.get(list.size() - 1) <= temp) {
            list.add(temp);
            return;
        }

        int val = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        insert(list, temp);
        list.add(val);
    }

    public static void main(String... args) {
        int[] arr = {1,7,3,9,6,4,5,};
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<=arr.length-1; i++) {
            list.add(arr[i]);
        }
        System.out.println("Before Sorting");
        System.out.println(list);
        sortUsingRecursion(list);
        System.out.println("After sorting");
        System.out.println(list);

    }
}
