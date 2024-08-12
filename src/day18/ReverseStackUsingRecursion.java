package day18;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    public static void reverseStack(Stack<Integer> stack) {

        if(stack.isEmpty()) return;

        int top = stack.pop();

        reverseStack(stack);

        insertAtBottom(stack, top);
    }

    public static void insertAtBottom(Stack<Integer> stack, int element) {

        if(stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, element);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] arr = {5,4,3,2,1};
        for(int val:arr)  stack.push(val);
        System.out.println("Before Reversing Stack");
        System.out.println(stack);
        reverseStack(stack);
        System.out.println("After reversing Stack");
        System.out.println(stack);
    }
}
