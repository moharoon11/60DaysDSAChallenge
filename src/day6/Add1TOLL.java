package day6;

public class Add1TOLL {

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public ListNode() {
            this.data = 0;
            this.next = null;
        }
    }

    public static ListNode add1ToLL(ListNode head) {
        head = reverse(head);

        ListNode temp = head;
        int carry = 1;
        while(temp != null) {
            temp.data = temp.data + carry;

            if(temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }

        head = reverse(head);

        if(carry == 1) {
            ListNode node = new ListNode(1);
            node.next = head;
            return node;
        }
        return head;
    }


    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while(temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }



    // recursive solution
    public static ListNode addOne(ListNode head) {
        int carry = helper(head);

        if(carry == 1) {
            ListNode node = new ListNode(1);
            node.next = head;
            return node;
        }

        return head;
    }

    public static int helper(ListNode temp) {
        if(temp == null) {
            return 1;
        }

        int carry = helper(temp.next);
        temp.data = temp.data + carry;

        if(temp.data < 10) {
            return 0;
        }

        temp.data = 0;
        return 1;
    }
}
