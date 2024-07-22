package day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLL {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }

        ListNode(int data, ListNode next) {
            this.val = data;
            this.next = next;
        }

        ListNode() {
            this.val = 0;
            this.next = null;
        }
    }


    // brute force approach
    public ListNode sortList(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode temp = head;

        while(temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        temp = head;
        Collections.sort(values);
        for(int i=0; i<values.size(); i++) {
            temp.val = values.get(i);
            temp = temp.next;
        }
        return head;
    }


    // optimal approach
    public ListNode sortList1(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode middle = findMiddle(head);
        ListNode secondHead = middle.next;
        middle.next = null;
        ListNode leftHead = sortList1(head);
        ListNode rightHead = sortList1(secondHead);

        return merge(leftHead, rightHead);
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        dummyNode.next = temp;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummyNode.next;
    }
}
