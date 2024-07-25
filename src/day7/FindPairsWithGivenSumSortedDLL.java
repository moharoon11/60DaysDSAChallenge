package day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairsWithGivenSumSortedDLL {

    public static class ListNode {

        int data;
        ListNode next;
        ListNode prev;

        ListNode() {}

        ListNode(int data) {
            this.data = data;
        }

        ListNode(int data, ListNode prev, ListNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public static ListNode convertArrToDLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode prev =  head;
        for(int i=1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i], prev, null);
            prev.next = node;
            prev = node;
        }

        return head;
    }

    public static void printDLL(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static List<Map<Integer, Integer>> findPairs(ListNode head, int target) {
        List<Map<Integer, Integer>> result = new ArrayList<>();
        Map<Integer, Integer> pairs = new HashMap<>();

        ListNode temp1 = head;

        while(temp1 != null) {
            ListNode temp2 = temp1.next;
            while(temp2 != null) {
                if( (temp1.data + temp2.data) == target) {
                    pairs.put(temp1.data, temp2.data);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }

        result.add(pairs);
        return result;
    }


    public static ListNode findTail(ListNode head) {
        ListNode temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public static List<List<Integer>> findPairsWithGivenSum(ListNode head, int sum) {
        if(head == null) return null;

        List<List<Integer>> result = new ArrayList<>();

        ListNode right = findTail(head);
        ListNode left = head;
        while(left.data < right.data) {

            if(left.data + right.data == sum) {
                List<Integer> temp = new ArrayList<>();
                temp.add(left.data);
                temp.add(right.data);
                result.add(temp);
                left = left.next;
                right = right.prev;
            } else if(left.data + right.data > sum) {
                right = right.prev;
            } else {
                left = left.next;
            }
        }

        return result;
    }


    public static void main(String... args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = convertArrToDLL(arr);
        System.out.println(findPairs(head, 5));
        System.out.println(findPairsWithGivenSum(head, 5));
    }
}
