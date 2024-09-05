package day33;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxOfAllSubArraySizeK {

    public static void main(String[] args) {

        int[] nums1 = {1, 3, -1, -3, 5,3,6,7};
        System.out.println(find(nums1, 3));
    }

    public static List<Integer> find(int[] arr, int k) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) ->  b - a);

        int i=0;
        int j=0;

        while(j < arr.length) {

            // calculations
            queue.add(arr[j]);

            if(j - i + 1 < k) {
                j++;
            } else if(j - i + 1 == k) {

                result.add(queue.peek());
                queue.remove(arr[i]);

                i++;
                j++;
            }
        }

        return result;
    }
}
