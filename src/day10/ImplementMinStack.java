package day10;


import java.util.Stack;

class Pair {

    int first;
    int second;

    Pair() {

    }

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

}


public class ImplementMinStack {

    Stack<Pair> stack;

    public ImplementMinStack() {
        stack = new Stack<Pair>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            Pair pair = new Pair(val, val);
            stack.push(pair);
            return;
        }


        Pair pair = new Pair(val, Math.min(val, stack.peek().second));
        stack.push(pair);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().first;
    }

    public int getMin() {
        return stack.peek().second;
    }
}