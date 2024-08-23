package day28;

public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode head = lists[0];

        for(int i=1; i<lists.length; i++) {
            head = merge(head, lists[i]);
        }

        return head;
    }

    public ListNode merge(ListNode head1, ListNode head2) {

        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }

        while(temp1 != null) {
            temp.next = temp1;
            temp = temp.next;
            temp1 = temp1.next;
        }

        while(temp2 != null) {
            temp.next = temp2;
            temp = temp.next;
            temp2 = temp2.next;
        }

        return dummyNode.next;
    }
}
