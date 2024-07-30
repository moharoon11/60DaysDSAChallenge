package day10;

public class ImplementStackUsingLinkedList {

    Node top;

    public class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    ImplementStackUsingLinkedList() {
        this.top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if(isEmpty()) return -1;
        int temp = top.value;
        top = top.next;
        return temp;
    }

    public int peek() {
        if(isEmpty()) return -1;
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
