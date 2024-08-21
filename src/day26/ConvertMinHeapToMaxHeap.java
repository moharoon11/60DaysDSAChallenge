package day26;

public class ConvertMinHeapToMaxHeap {

    static void convertMinToMaxHeap(int N, int arr[]) {
        // Step: Perform down-heap for all non-leaf nodes
        for (int i = (N / 2) - 1; i >= 0; i--) {
            downHeap(arr, N, i); // N is used to maintain the size of the heap
        }
    }

    static void downHeap(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue down-heap
        if (largest != i) {
            swap(arr, i, largest);
            downHeap(arr, n, largest);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
