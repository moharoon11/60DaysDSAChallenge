package day16;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {

    List<Integer> list;
//   I commented this cause i need this constructor in optimal solution
//    public StockSpan() {
//        list = new ArrayList<Integer>();
//    }

    // brute force approach
    public int next(int price) {
        list.add(price);
        int count = 1;
        for(int i=list.size() - 2; i>=0; i--) {
            if(list.get(i) <= price) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    // optimized solution
    class Pair {

        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }
    Stack<Pair> stack;
    int index;
    StockSpan() {
        stack = new Stack<>();
        index = -1;
    }

    public int next1(int price) {

        index = index + 1;

        while(!stack.isEmpty() && stack.peek().first <= price) {
            stack.pop();
        }

        int ans = index - (stack.isEmpty() ? -1 : stack.peek().second);
        stack.push(new Pair(price, index));

        return ans;
    }
}
