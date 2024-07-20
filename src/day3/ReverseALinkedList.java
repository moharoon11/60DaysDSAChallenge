package day3;

import java.util.Stack;

public class ReverseALinkedList {

    private static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }


    }

      public static Node convertArrToLL(int[] arr) {
              Node head = new Node(arr[0]);
              Node temp = head;
              for(int i=1; i<arr.length; i++) {
                  Node newNode = new Node(arr[i]);
                  temp.next = newNode;
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

          public static Node reverseLL(Node head) {
               Stack<Integer> stack = new Stack();
               Node temp = head;
               while(temp != null) {
                   stack.push(temp.data);
                   temp = temp.next;
               }
               temp = head;
               while(!stack.isEmpty()) {
                   temp.data = stack.pop();
                   temp = temp.next;
               }

               return head;
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

          public static Node recursiveReverse(Node head) {
            if(head == null || head.next == null) {
                return head;
            }

            Node newHead = recursiveReverse(head.next);
            Node front = head.next;
            front.next = head;
            head.next = null;
            return newHead;
          }


    public static void main(String... args) {
        int[] arr = {1,2,3,4,5};
        Node head = convertArrToLL(arr);
        printLL(head);
        head = recursiveReverse(head);
        printLL(head);
    }
}
