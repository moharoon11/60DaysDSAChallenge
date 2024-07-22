package day5;

public class DeleteMiddle {

    public static class ListNode {
        int data;
        ListNode next;
    }


    // brute force approach
    public static ListNode removeMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        int length = getLength(head);
        int middleNode = length /  2;

        ListNode temp = head;
        while(temp != null) {
            middleNode--;
            if(middleNode == 0) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }


    public static int getLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // optimal approach
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }


}
