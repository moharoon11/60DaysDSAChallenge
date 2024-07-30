package day10;

public class ImplementQueueUsingLinkedList {

    Node front;
    Node rear;

    public class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    ImplementQueueUsingLinkedList() {
        this.front = null;
        this.rear = null;
    }

    public void add(int x) {
        Node newNode = new Node(x);
        if(rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int pop() {
        if(isEmpty()) return -1;
        int temp = front.data;
        front = front.next;
        if(front == null) {
            rear = null;
        }
        return temp;
    }

    public int peek() {
        if(isEmpty()) return -1;
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

}
