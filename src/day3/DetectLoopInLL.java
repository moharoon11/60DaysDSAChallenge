package day3;

import java.util.HashMap;
import java.util.Map;

public class DetectLoopInLL {

    public static class Node {

        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }


    }


    public static boolean isLoop(Node head) {
        Map<Node, Integer> nodes = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            if(nodes.containsKey(temp)) {
                return true;
            }
            nodes.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    // slow and fast pointer approach
    public static boolean isThereLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }


}
