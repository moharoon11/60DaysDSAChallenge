package day26;

import java.util.ArrayList;

public class ExtractMax<T extends Comparable<T>> {

    private ArrayList<T> list;

    public ExtractMax() {
        list = new ArrayList<>();
    }

    public void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int left(int index) {
        return (index * 2) + 1;
    }

    public int right(int index) {
        return (index * 2) + 2;
    }

    public void insert(T value) {
        list.add(value);
        upHeap(list.size() - 1);
    }

    public void upHeap(int index) {
        if(index == 0) return;

        int p = parent(index);

        if(list.get(index).compareTo(list.get(p)) > 0) {
            swap(index, p);
            upHeap(p);
        }
    }

    public T remove() throws Exception {
        if(list.isEmpty()) {
            throw new Exception("List is empty");
        }

        T temp = list.get(0);
        T last = list.get(list.size() - 1);
        list.set(0, last);
        list.remove(list.size() - 1);

        if(!list.isEmpty()) {
            downHeap(0);
        }

        return temp;
    }

    public void downHeap(int index) {
        int max = index;
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(left).compareTo(list.get(max)) > 0) {
            max = left;
        }

        if(right < list.size() && list.get(right).compareTo(list.get(max)) > 0) {
            max = right;
        }

        if(index != max) {
            swap(index, max);
            downHeap(max);
        }
    }


    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

    public T extractMax() throws Exception {
        if(list.isEmpty()) {
            throw new Exception("List is empty");
        }
        return this.remove();
    }

}
