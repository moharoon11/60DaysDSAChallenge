package day28;

import java.util.TreeMap;

public class HandOfStraights {

    /**
     * This is exactly like minHeap
     * instead of creating a seperate pair class and storing the key and its frequency
     * then put that in prorityqueue and sorting it by key
     * we just use treemap which basically has the first element as minimum and that is our key
     * this is exactly min heap concept
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {

        TreeMap<Integer, Integer> chars_count = new TreeMap<>();

        for (int card : hand) {
            chars_count.put(card, chars_count.getOrDefault(card, 0) + 1);
        }

        while (chars_count.size() > 0) {
            int minVal = chars_count.firstKey();
            for (int card = minVal; card < minVal + groupSize; card++) {
                if (!chars_count.containsKey(card)) return false;
                int count = chars_count.get(card);
                if (count == 1) {
                    chars_count.remove(card);
                } else {
                    chars_count.put(card, chars_count.get(card) - 1);
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[] arr1 ={1,2,3,6,2,3,4,7,8};
        int groupSize1 = 3;

        int[] arr2 = {1,2,3,4,5};
        int groupSize2 = 4;
    }

}
