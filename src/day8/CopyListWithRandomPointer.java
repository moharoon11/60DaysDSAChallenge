package day8;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static class ListNode {

        int data;
        ListNode next;
        ListNode randomPointer;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public static ListNode copy(ListNode head) {
        ListNode temp = head;
        Map<ListNode, ListNode> map = new HashMap<>();

        while(temp != null) {
            ListNode node = new ListNode(temp.data);
            map.put(temp, node);
            temp = temp.next;
        }

        temp = head;

        while(temp != null) {
            ListNode copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.randomPointer = map.get(temp.randomPointer);
            temp = temp.next;
        }

        return map.get(head);
    }


    // insert a copy node in between
    // connect the random pointers
    // connect the next pointers
    public static ListNode copyLinkedList(ListNode head) {

        ListNode temp = head;
        while(temp != null) {
            ListNode node = new ListNode(temp.data);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }

        temp = head;

        while(temp != null) {
            ListNode copyNode = temp.next;

            if(temp.randomPointer != null) {
                copyNode.randomPointer = temp.randomPointer.next;
            } else {
                copyNode.randomPointer = null;
            }
            temp = temp.next.next;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        temp = head;

        while(temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }

}
