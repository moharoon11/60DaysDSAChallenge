package day17;

import java.util.Stack;

public class SortAStackUsingRecursion {

    public static void sortStack(Stack<Integer> stack) {

        if(stack.size() == 1) return;

        int temp = stack.pop();
        sortStack(stack);
        insert(stack, temp);
    }

    public static void insert(Stack<Integer> stack, int temp) {
        if(stack.size() == 0 || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        int value = stack.pop();
        insert(stack, temp);
        stack.push(value);
    }
    public static void main(String[] args) {
        int[] arr = {5,1,0,2};
        Stack<Integer> stack = new Stack<>();
        for(int val:arr) {
            stack.push(val);
        }
        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);

    }
}
