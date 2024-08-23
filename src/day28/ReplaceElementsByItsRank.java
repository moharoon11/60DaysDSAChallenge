package day28;

import java.util.PriorityQueue;

public class ReplaceElementsByItsRank {

    public static class Pair {

        int value;
        int position;

        Pair(int value, int position) {
            this.value = value;
            this.position = position;
        }
    }
    static int[] replaceWithRank(int arr[], int N) {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        for(int i=0; i<N; i++) {
            minHeap.offer(new Pair(arr[i], i));
        }

        int[] result = new int[N];
        int rank = 1;

        Pair previous = minHeap.poll();
        result[previous.position] = rank;

        while(!minHeap.isEmpty()) {
            Pair current = minHeap.poll();

            if(previous.value != current.value) {
                rank++;
            }

            result[current.position] = rank;
            previous = current;
        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr = {20, 15, 26, 2, 98, 6};
    }
}
