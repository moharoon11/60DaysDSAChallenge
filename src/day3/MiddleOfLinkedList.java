package day3;

import day2.DLL;

public class MiddleOfLinkedList {

    static class Node {

        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static Node convertArrToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.setNext(newNode);
            temp = newNode;
        }
        return head;
    }

    public static void printLL(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node findMiddle(Node head) {
        int length = getLength(head);
        int midNode = (length / 2) + 1;
        Node temp = head;
        Node result = null;
        while(temp != null) {
            midNode--;
            if(midNode == 0) {
                result = temp;
                break;
            }
            temp = temp.next;
        }
        return result;
    }

    public static int getLength(Node head) {
        int length = 0;

        Node temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // slow and fast pointer approach
    public static Node getMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5,6,7,8,9,10};
       Node head = convertArrToLL(arr);
       printLL(head);

    }
}
