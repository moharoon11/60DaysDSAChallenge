package day5;

public class SortLLOF0s1s2sbychangingLinks {

    public static class ListNode {

        int data;
        ListNode next;

        public ListNode(ListNode next, int data) {
            this.next = next;
            this.data = data;
        }

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode() {
            this.data = 0;
            this.next = null;
        }
    }


    // Brute force approach
    public static ListNode sortLL(ListNode head) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        ListNode temp = head;

        while(temp != null) {
            if(temp.data == 0) cnt0++;
            else if(temp.data == 1) cnt1++;
            else cnt2++;

            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(cnt0 > 0) {
                temp.data = 0;
                cnt0--;
            } else if(cnt1 > 0) {
                temp.data =1;
                cnt1--;
            } else {
                temp.data = 2;
                cnt2--;
            }
            temp = temp.next;
        }

        return head;
    }


    // optimal approach
    public static ListNode sortLLChangingLinks(ListNode head) {
        if(head == null || head.next == null) return head;

       ListNode zero = new ListNode(-1);
       ListNode one = new ListNode(-1);
       ListNode two = new ListNode(-1);

       ListNode zeroHead = zero;
       ListNode oneHead = one;
       ListNode twoHead = two;
       ListNode temp = head;

       while(temp != null) {
           if(temp.data == 0) {
               zero.next = temp;
               zero = zero.next;
           } else if(temp.data == 1) {
               one.next = temp;
               one = one.next;
           } else {
               two.next = temp;
               two = two.next;
           }
           temp = temp.next;
       }

        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

       return zeroHead.next;
    }


}
