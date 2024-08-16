package day22;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    // TC: O(n log n) + O(n)
    // SC: O(1)
    double fractionalKnapsack(int w, Item arr[], int n) {

        Arrays.sort(arr, Comparator.comparingDouble((Item item)
                -> (double) item.value / item.weight).reversed());

        double total = 0.0;

        for(int i=0; i<n; i++) {
            if(arr[i].weight <= w) {
                total += arr[i].value;
                w -= arr[i].weight;
            } else {
                total +=  ((double) arr[i].value / arr[i].weight) * w;
                break;
            }
        }

        return total;
    }
}
