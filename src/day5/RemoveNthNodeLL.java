package day5;

public class RemoveNthNodeLL {

    public static class ListNode {
        int data;
        ListNode next;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;

        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }


        if(length == n) {
            head = head.next;
            return head;
        }
        // previous position of the node we need to remove
        int till = length - n;
        temp = head;
        for(int i=1; i<till; i++) {
            temp = temp.next;
        }

        ListNode front = temp.next;
        temp.next = front.next;
        front.next = null;

        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head == null || head.next == null) return null;

        ListNode fast = head;
        for(int i=1; i<=n; i++) fast = fast.next;
        if(fast == null) return head.next;
        ListNode slow = head;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode deleteNode  = slow.next;
        slow.next = slow.next.next;
        return head;
    }
}
