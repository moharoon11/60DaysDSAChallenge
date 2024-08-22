package day27;

import java.util.PriorityQueue;
import java.util.ArrayList;

public class MergeKSortedArrays {

    static class Data {

        int value;
        int arrPosition;
        int valuePosition;


        Data(int value, int arrPosition, int valuePosition) {
            this.value = value;
            this.arrPosition = arrPosition;
            this.valuePosition = valuePosition;
        }
    }
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K)
    {
        ArrayList<Integer> list = new ArrayList<>();

        PriorityQueue<Data> minHeap = new PriorityQueue<>((a,b)-> a.value - b.value);

        for(int i=0; i<K; i++) {
            minHeap.offer(new Data(arr[i][0], i, 0));
        }


        while(!minHeap.isEmpty()) {
            Data data = minHeap.poll();
            list.add(data.value);

            if(data.valuePosition + 1 < arr[data.arrPosition].length) {
                minHeap.offer(new Data(arr[data.arrPosition][data.valuePosition+1], data.arrPosition, data.valuePosition + 1));
            }
        }


        return list;
    }

}
