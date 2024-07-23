package day6;

public class Add2LL {

    public static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int carry = 0;
        while(t1 != null || t2 != null) {
            int sum = carry;

            if(t1 != null) sum = t1.val + sum;
            if(t2 != null) sum = sum + t2.val;

            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            current.next = newNode;
            current = current.next;

            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }

        if(carry == 1) {
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
            current = current.next;
        }

        return dummyNode.next;
    }
}
