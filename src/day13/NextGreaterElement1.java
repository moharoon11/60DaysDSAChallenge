package day13;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            boolean found = false;
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    found = false;
                    for(int k = j + 1; k < nums2.length; k++) {
                        if(nums2[k] > nums1[i]) {
                            result[i] = nums2[k];
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        result[i] = -1;
                    }
                    break;
                }
            }
        }
        return result;
    }


    // monotonic stack
    public int[] nextGreaterElementUsingStack(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<>();

        for(int i=nums2.length - 1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                map.put(nums2[i], stack.peek());
            } else {
                map.put(nums2[i], -1);
            }
            stack.push(nums2[i]);
        }


        int[] result = new int[nums1.length];
        for(int i=0; i<result.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
