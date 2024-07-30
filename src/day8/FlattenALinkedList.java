package day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlattenALinkedList {

    public static class ListNode {
        int data;
        ListNode next;
        ListNode child;

        public ListNode(int data) {
            this.data = data;
        }

    }

    public static ListNode flatten(ListNode head) {
        List<Integer> values = new ArrayList<Integer>();
        ListNode temp = head;

        while(temp != null) {
            ListNode temp2 =  temp;
            while(temp2 != null) {
                values.add(temp2.data);
                temp2 = temp2.child;
            }
            temp = temp.next;
        }

        Collections.sort(values);

        head = new ListNode(values.get(0));
        ListNode node = head;

        for(int i=1; i<values.size(); i++) {
            ListNode newNode = new ListNode(values.get(i));
            node.child = newNode;
            node = node.child;
        }

        return head;
    }

    // recursive approach
    public static ListNode flattenLinkedList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode mergedHead = flattenLinkedList(head.next);
        return merge(head, mergedHead);
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                res.child = l1;
                res = l1;
                l1 = l1.child;
            } else {
                res.child = l2;
                res = l2;
                l2 = l2.child;
            }
            res.next = null;
        }

        if (l1 != null) {
            res.child = l1;
        } else {
            res.child = l2;
        }

        // Break the last node's
        // link to prevent cycles
        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }

        return dummyNode.child;
    }
}
