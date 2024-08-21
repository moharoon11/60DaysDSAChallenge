package day22;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AssignCookies {


    // TC: O(n log n) + O(m log n) + O(n)
    // SC: O(1)
    public static int findContentChildren(int[] g, int[] s) {

        int left = 0;
        int right = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while(left < g.length && right < s.length) {
            if(s[right] >= g[left]) {
                left++;
            }
            right++;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] greed = {1, 5, 3, 3, 4};
        int[] size = {4, 2, 1, 2, 1, 3};
        int ans = findContentChildren(greed, size);
        System.out.println(ans);
    }

}
