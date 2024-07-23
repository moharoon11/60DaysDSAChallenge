package day6;

public class DeleteAllOccurenceOfKeyINDLL {

    public static class ListNode {

        int data;
        ListNode next;
        ListNode prev;

        ListNode() {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

        ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode next, ListNode prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

    }

    public static ListNode deleteKeyInDLL(ListNode head, int key) {
        ListNode temp = head;

        while(temp != null) {
            if(temp.data == key) {
                if(temp == head) {
                    head = head.next;
                }

                ListNode front = temp.next;
                ListNode prev = temp.prev;

                if(front != null) front.prev = prev;
                if(prev != null) prev.next = front;

                temp = front;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}
