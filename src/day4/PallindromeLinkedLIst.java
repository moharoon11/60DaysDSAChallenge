package day4;

import java.util.Stack;

public class PallindromeLinkedLIst {


    public static class Node {
        // Data stored in the node
        int data;
        // Pointer to the next
        // node in the list
        Node next;

        // Constructor with both data
        // and next node as parameters
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Constructor with only data as
        // a parameter, sets next to null
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public static boolean isPalindrome(Node head) {
        // Create an empty stack
        // to store values
        Stack<Integer> st = new Stack<>();

        // Initialize a temporary pointer
        // to the head of the linked list
        Node temp = head;

        // Traverse the linked list and
        // push values onto the stack
        while (temp != null) {
            // Push the data from the
            // current node onto the stack
            st.push(temp.data);

            // Move to the next node
            temp = temp.next;
        }

        // Reset the temporary pointer back
        // to the head of the linked list
        temp = head;

        // Compare values by popping from the stack
        // and checking against linked list nodes
        while (temp != null) {
            if (temp.data != st.peek()) {
                // If values don't match,
                // it's not a palindrome
                return false;
            }

            // Pop the value from the stack
            st.pop();

            // Move to the next node
            // in the linked list
            temp = temp.next;
        }

        // If all values match,
        // it's a palindrome
        return true;
    }


    // optimal approach
    public boolean isPalindrome2(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        // the tail is head of the second half but we call it tail because it is the last element of the
        // linked list
        Node tail = reverse(slow.next);
        Node second = tail;

        Node temp = head;
        while(second !=null) {
            if(temp.data != second.data) {
                reverse(tail);
                return false;
            }
            temp = temp.next;
            second = second.next;
        }

        reverse(tail);
        return true;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node temp = head;
        while(temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }



    // Function to print the linked list
    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with
        // values 1, 5, 2, 5, and 1 (15251, a palindrome)
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Check if the linked list is a palindrome
        if (isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
