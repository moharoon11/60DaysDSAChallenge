package day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLL {

    public static class ListNode {
        int val;
        ListNode next;
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
}
