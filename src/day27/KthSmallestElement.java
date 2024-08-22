package day27;

import java.util.*;

public class KthSmallestElement {

    public static int kthSmallest(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: arr) list.add(num);

        int n = arr.length;

        for(int i=(n/2)-1; i>=0; i--) {
            minifyHeap(i, n, list);
        }


        for(int i=0; i<k-1; i++) {
            Collections.swap(list, 0, n-1-i);

            minifyHeap(0, n - 1 - i, list);
        }
        return list.get(0);
    }

    public static int left(int index) {
        return (index * 2) + 1;
    }

    public static int right(int index) {
        return (index * 2) + 2;
    }

    public static void minifyHeap(int index, int n, ArrayList<Integer> list) {
        int smallest = index;
        int left = left(index);
        int right = right(index);

        if(left < n && list.get(left) < list.get(smallest)) {
            smallest = left;
        }

        if(right < n && list.get(right) < list.get(smallest)) {
            smallest = right;
        }

        if(index != smallest) {
            Collections.swap(list, index, smallest);
            minifyHeap(smallest, n, list);
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
      //  Output:  7


         int[] arr1 = {7, 10, 4, 20, 15};
         int k1 = 4;
       // Output:  15
    }
}
