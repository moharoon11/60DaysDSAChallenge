package day4;
import java.util.HashMap;
public class LengthOfLoopInLL {

    public static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this.data = data;
        }
    }

    public static int countLength(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            if(!map.containsKey(temp)) {
                map.put(temp, 1);
                temp = temp.next;
            } else {
                HashMap<Node, Integer> loop = new HashMap<>();
                Node tLoop = temp;
                int counter = 1;
                loop.put(tLoop, 1);
                tLoop = tLoop.next;
                while(tLoop != null) {
                    if(!loop.containsKey(tLoop)) {
                        counter++;
                        tLoop = tLoop.next;
                    } else {
                        return counter;
                    }
                }
            }

        }

        return -10;
    }

    // brute force using hashing
    public static int findLength(Node head) {
        HashMap<Node, Integer> visited = new HashMap<>();

        Node temp = head; int timer = 1;
        while(temp != null) {

            if(visited.containsKey(temp)) {
                return timer - visited.get(temp);
            }

            visited.put(temp, timer);
            temp = temp.next;
            timer++;
        }

        return 0;
    }


    // optimal approach
    static int countNodesinLoop(Node head)
    {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                int counter = 1; fast = fast.next;
                while(slow != fast) {
                    counter++;
                    fast = fast.next;
                }
                return counter;
            }
        }
        return 0;
    }



    public static void main(String... args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Create a loop from fifth to second
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // This creates a loop
        fifth.next = second;

        int loopLength = countLength(head);

        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }
}
