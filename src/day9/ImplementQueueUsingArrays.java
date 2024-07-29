package day9;

public class ImplementQueueUsingArrays {

    int[] queueArray;
    int maxSize;
    int front;
    int rear;
    int nItems;

    public ImplementQueueUsingArrays(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public void add(int value) {
        if(isFull()) {
            System.out.println("Queue is full cannot add the given value " + value);
        } else {
            if(rear == (maxSize - 1)) { // WRAP AROUND
                rear = -1;
            }
            queueArray[++rear] = value;
            nItems++;
        }
    }

    public int removeFirst() {
        if(isEmpty()) {
            return -1;
        } else {
            int temp = queueArray[front++];
            if(front == maxSize) {
                front = 0;
            }
            nItems--;
            return temp;
        }
    }

    public int getFirst() {
        if(isEmpty()) {
            return -1;
        }
        return queueArray[front];
    }

    public int size() {
        return nItems;
    }

}
