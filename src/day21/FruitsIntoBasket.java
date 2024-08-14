package day21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsIntoBasket {

    /*
      BRUTE APPROACH
      TIME COMPLEXITY:  O(n ^ 2)
      SPACE COMPLEXITY: O(3)
     */
    public static int calculate(int[] arr, int n, int nTypes) {
        int maxLen = 0;

        for(int i=0; i<n; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=i; j<n; j++) {
                set.add(arr[j]);
                if(set.size() <= nTypes) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }


    /**************** OPTIMAL APPROACH USING SLIDING WINDOW ****************************/
    // TIME COMPLEXITY: O(n)
    // SPACE COMPLEXITY: O(1)
    public static int totalFruits(Integer[] arr, int n, int nTypes) {
        int left = 0, right = 0, maxLen =0;
        Map<Integer, Integer> map = new HashMap<>();

        while(right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            if(map.size() > nTypes) {
                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);
                if(map.get(arr[left]) == 0) map.remove(arr[left]);
                left++;
            }

            if(map.size() <= nTypes) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }




    public static void main(String[] args) {

    }

}
