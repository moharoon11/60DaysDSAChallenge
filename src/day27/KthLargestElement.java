package day27;

import java.util.ArrayList;
import java.util.Collections;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) list.add(nums[i]);

        int n = nums.length;

        for(int i=n/2 - 1; i>=0; i--) {
            maxifyHeap(i,n, list);
        }

        for(int i=0; i<k-1; i++) {
            Collections.swap(list, 0, n - 1 - i);

            maxifyHeap(0, n - 1 - i, list);
        }

        return list.get(0);
    }



    public int left(int index) {
        return (index * 2) + 1;
    }

    public int right(int index) {
        return (index * 2) + 2;
    }

    public void maxifyHeap(int index, int n, ArrayList<Integer> list) {
        int largest = index;
        int left = left(index);
        int right = right(index);

        if(left < n && list.get(left) > list.get(largest)) {
            largest = left;
        }

        if(right < n && list.get(right) > list.get(largest)) {
            largest = right;
        }

        if(index != largest) {
            Collections.swap(list, index, largest);
            maxifyHeap(largest, n, list);
        }
    }

    public static void main(String[] args) {
       int[] nums = {3,2,1,5,6,4};
        int k = 2;
        // Output: 5

        int[] nums1 = {3,2,3,1,2,4,5,5,6};
        int k1 = 4;
        // Output: 4

    }
}
