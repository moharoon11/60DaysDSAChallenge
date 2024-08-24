package day29;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentElements {

    public class Pair {

        int key;
        int frequency;

        public Pair(int key, int frequency) {
            this.key = key;
            this.frequency = frequency;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int[] ansList = new int[k];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);

        // calculate the frequency
        for(int i=0; i<nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }

        // make the maxheap with the frequency calculated
        for(Map.Entry<Integer, Integer> entry:frequencyMap.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            maxHeap.offer(pair);
        }

        // store the first k frequent elements from the maxheap
        for(int i=0; i<=k-1; i++) {
            Pair pair = maxHeap.poll();
            ansList[i] = pair.key;
        }

        return ansList;
    }

}
