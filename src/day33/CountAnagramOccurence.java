package day33;

import java.util.HashMap;
import java.util.Map;

public class CountAnagramOccurence {


    public static int count(String s, String pattern) {
        int k = pattern.length();

        Map<Character, Integer> map = new HashMap<>();

        for(char ch:pattern.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = map.size();
        int ans = 0;
        int start = 0;
        int end = 0;

        while(end < s.length()) {

            char ch = s.charAt(end);

            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) count--;
            }

            if(end - start + 1 < k) {
                end++;
            } else if(end - start + 1 == k) {
                if(count == 0) ans++;

                char windowStart = s.charAt(start);

                if(map.containsKey(windowStart)) {
                     map.put(windowStart, map.get(windowStart) + 1);
                     if(map.get(windowStart) == 1) count++;
                }

                start++;
                end++;


            }
        }

        return ans;
    }
    public static void main(String[] args) {

    }
}
