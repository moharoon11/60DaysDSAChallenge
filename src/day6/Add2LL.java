package day6;

public class Add2LL {

    public static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

    public static void main(String... args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(6);

        a1.next = a2;
        a2.next = a3;
        a3.next = null;

        ListNode head = addTwoNumbers(l1, l2);

        ListNode temp = head;

        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
