package day9;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;
    public ImplementStackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        top = -1;
    }

    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    public int pop() {
        if(queue1.isEmpty()) {
            return -1;
        }

        while(queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        int poppedValue = queue1.remove();

        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedValue;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

