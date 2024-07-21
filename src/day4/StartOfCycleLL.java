package day4;

import java.util.HashMap;

public class StartOfCycleLL {

    public class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node detectLoop(Node head) {
        // Use temp to traverse the linked list
        Node temp = head;

        // HashMap to store all visited nodes
        HashMap<Node, Integer> nodeMap = new HashMap<>();

        // Traverse the list using temp
        while (temp != null) {
            // Check if temp has been encountered again
            if (nodeMap.containsKey(temp)) {
                // A loop is detected, hence return temp
                return temp;
            }

            // Store temp as visited
            nodeMap.put(temp, 1);

            // Iterate through the list
            temp = temp.next;
        }
        // If no loop is detected, return null
        return null;
    }

    public static Node firstNode(Node head) {
        // Initialize a slow and fast
        // pointers to the head of the list
        Node slow = head;
        Node fast = head;

        // Phase 1: Detect the loop
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;

            // Move fast two steps
            fast = fast.next.next;

            // If slow and fast meet,
            // a loop is detected
            if (slow == fast) {
                // Reset the slow pointer
                // to the head of the list
                slow = head;

                // Phase 2: Find the first node of the loop
                while (slow != fast) {
                    // Move slow and fast one step
                    // at a time
                    slow = slow.next;
                    fast = fast.next;

                    // When slow and fast meet again,
                    // it's the first node of the loop
                }

                // Return the first node of the loop
                return slow;
            }
        }

        // If no loop is found, return null
        return null;
    }
}
