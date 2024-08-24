package day29;

import java.util.*;

// If 2 words has the same frequency it should be sorted by the key in lexicographically and
// should be stored in ascending order
// that was handled in custom comparator
/* here the code
 PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
                if (b.frequency == a.frequency) {
                    return a.key.compareTo(b.key); // Lexicographical order
                } else {
                    return b.frequency - a.frequency; // Frequency order
                }
            });
 */
public class KMostFrequentWords {

    class Solution {

        public class Pair {

            String key;
            int frequency;

            public Pair(String key, int frequency) {
                this.key = key;
                this.frequency = frequency;
            }
        }
        public List<String> topKFrequent(String[] words, int k) {
            List<String> ansList = new ArrayList<>();
            Map<String, Integer> frequencyMap = new HashMap<>();

            // calculate the frequency
            for(String word:words) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }

            PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
                if (b.frequency == a.frequency) {
                    return a.key.compareTo(b.key); // Lexicographical order
                } else {
                    return b.frequency - a.frequency; // Frequency order
                }
            });
            // use maxheap to store the most frequenct words at the top
            for(Map.Entry<String, Integer> entry: frequencyMap.entrySet()) {
                Pair pair = new Pair(entry.getKey(), entry.getValue());
                maxHeap.offer(pair);
            }

            for(int i=0; i<=k-1; i++) {
                ansList.add(maxHeap.poll().key);
            }


            return ansList;
        }
    }
}
