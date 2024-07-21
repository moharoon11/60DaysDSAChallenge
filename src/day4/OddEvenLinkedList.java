package day4;

import java.util.ArrayList;
import java.util.List;

public class OddEvenLinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


  // brute force approach
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;
        List<Integer> values = new ArrayList<Integer>();
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            values.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null) values.add(temp.val);

        temp = head.next;

        while(temp != null && temp.next != null) {
            values.add(temp.val);
            temp=temp.next.next;
        }
        if(temp != null) values.add(temp.val);
        temp = head;
        for(int i=0; i<values.size(); i++) {
            temp.val = values.get(i);
            temp = temp.next;
        }
        return head;
    }


    // optimal approach
    public ListNode oddEvenList1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }



}
