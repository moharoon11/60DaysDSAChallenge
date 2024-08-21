package day26;

public class MinHeapArray {


        int[] harr;      // Array to hold the heap
        int capacity;    // Maximum possible size of min heap
        int heap_size;   // Current number of elements in the min heap

        // Constructor to initialize the heap
        MinHeapArray(int cap) {
            heap_size = 0;
            capacity = cap;
            harr = new int[cap];
        }

        int parent(int i) { return (i - 1) / 2; }
        int left(int i) { return (2 * i + 1); }
        int right(int i) { return (2 * i + 2); }

        // Function to extract the minimum value in the heap
        int extractMin() {
            if (heap_size <= 0) {
                return -1; // If the heap is empty
            }
            if (heap_size == 1) {
                heap_size--;
                return harr[0]; // If only one element, return it
            }

            int root = harr[0];  // Store the minimum value to return
            harr[0] = harr[heap_size - 1]; // Move the last element to the root
            heap_size--; // Reduce the size of the heap
            MinHeapify(0); // Call MinHeapify to maintain the heap property
            return root;
        }

        // Function to insert a key into the heap
        void insertKey(int k) {
            if (heap_size == capacity) return; // Heap is full, cannot insert

            // Insert the new key at the end
            harr[heap_size] = k;
            heap_size++;

            // Up-Heap to maintain heap property
            upHeap(heap_size - 1);
        }

        // Function to delete a key at index i
        void deleteKey(int i) {
            if (i < 0 || i >= heap_size) return; // Invalid index

            // Replace the key to be deleted with the last key
            harr[i] = harr[heap_size - 1];
            heap_size--; // Reduce the size

            // Call MinHeapify to maintain the heap property
            if (i < heap_size) {
                MinHeapify(i);
            }
        }

        // Function to decrease the value at index i
        void decreaseKey(int i, int new_val) {
            if (i < 0 || i >= heap_size || new_val > harr[i]) return; // Invalid operation
            harr[i] = new_val;

            // Up-Heap to maintain heap property
            upHeap(i);
        }

        // MinHeapify function to maintain the heap property
        void MinHeapify(int i) {
            int smallest = i;
            int l = left(i);
            int r = right(i);

            // Check if left child is smaller than root
            if (l < heap_size && harr[l] < harr[smallest]) {
                smallest = l;
            }

            // Check if right child is smaller than smallest so far
            if (r < heap_size && harr[r] < harr[smallest]) {
                smallest = r;
            }

            // If smallest is not root, swap and call MinHeapify recursively
            if (smallest != i) {
                swap(i, smallest);
                MinHeapify(smallest);
            }
        }

        // Up-Heap to maintain heap property
        void upHeap(int i) {
            while (i != 0 && harr[parent(i)] > harr[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        // Function to swap two elements in the heap
        void swap(int first, int second) {
            int temp = harr[first];
            harr[first] = harr[second];
            harr[second] = temp;
        }


}
