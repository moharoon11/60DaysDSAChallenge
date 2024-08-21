package day26;

public class ArrayRepresentMinHeapOrNot {
    public long parent(long i) {
        return (i - 1) / 2;
    }

    public boolean countSub(long arr[], long n) {
        for(long start = n - 1; start >= 1; start--) {
            long p = parent(start);
            if(arr[(int) p] < arr[(int) start]) {
                return false; // Not a min-heap
            }
        }
        return true; // Is a min-heap
    }

}
