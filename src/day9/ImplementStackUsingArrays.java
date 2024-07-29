package day9;

public  class ImplementStackUsingArrays {

    int[] stackArray;
    int maxSize;
    int top;

    public ImplementStackUsingArrays(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        top = -1;
    }

    public  void push(int value) {
        if(isFull()) {
            System.out.println("Stack is full cannot push the given value " + value);
        } else {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public int size() {
        return top + 1;
    }

    public  boolean isEmpty() {
        return top == -1;
    }

    public  boolean  isFull() {
        return top == (maxSize - 1);
    }
}
