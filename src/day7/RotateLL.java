package day7;

public class RotateLL {

    public static class ListNode {
        int data;
        ListNode prev;
        ListNode next;


    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null||head.next == null||k == 0) return head;

        ListNode temp = head;
        int length = 1;
        while(temp.next != null) {
            ++length;
            temp = temp.next;
        }

        temp.next = head;
        k = k%length;
        int end = length-k;
        while(end--!=0) temp = temp.next;
        head = temp.next;
        temp.next = null;

        return head;
    }
}
