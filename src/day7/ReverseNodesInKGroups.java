package day7;

public class ReverseNodesInKGroups {

    public static class ListNode {
        int data;
        ListNode next;

    }
    public ListNode findKthNode(ListNode temp, int k) {
        k--;
        while(temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        ListNode temp = head;
        ListNode prevLast = null;
        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null) {
                if(prevLast != null) {
                    prevLast.next = temp;
                    break;
                }
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLinkedList(temp);

            if(head == temp) {
                head = kthNode;
            } else {
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }

    public void reverseLinkedList(ListNode temp) {
        if(temp == null || temp.next == null) return;
        ListNode prev = null;
        while(temp != null ) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
    }
}
