package day6;

import java.util.HashMap;

public class IntersectionOfLL {

    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        ListNode() {
            this.data = 0;
            this.next = null;
        }
    }


    // brute approach
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashMap<ListNode, Integer> map = new HashMap<>();

        ListNode temp1 = headA;

        while(temp1 != null) {
            map.put(temp1, 1);
            temp1 = temp1.next;
        }

        ListNode temp2 = headB;

        while(temp2 != null) {
            if(map.containsKey(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }

        return null;
    }

    // better approach
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        int n1 = 0, n2 = 0;
        ListNode temp1 = headA, temp2 = headB;

        while(temp1 != null) {
            n1++;
            temp1 = temp1.next;
        }

        while(temp2 != null) {
            n2++;
            temp2 = temp2.next;
        }

        if(n1 < n2) {
            return collision(headA, headB, n2-n1);
        } else {
            return collision(headB, headA, n1-n2);
        }
    }

    public ListNode collision(ListNode smaller, ListNode larger, int d) {

        while(d-- > 0) {
            larger = larger.next;
        }

        while(smaller != larger) {
            smaller = smaller.next;
            larger = larger.next;
        }

        return smaller;
    }


    // optimal approach

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) return null;

        ListNode t1 = headA;
        ListNode t2 = headB;

        while(t1 !=  t2) {

            t1 = t1.next;
            t2 = t2.next;

            if(t1 ==  t2) return t1;

            if(t1 == null) t1 = headB;
            if(t2 == null) t2 = headA;
        }

        return t1;
    }

}
