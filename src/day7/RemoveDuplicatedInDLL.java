package day7;

public class RemoveDuplicatedInDLL {

    public static class ListNode {
        int data;
        ListNode prev;
        ListNode next;

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

    public static void removeDuplicates(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode temp = head;

        while(temp != null && temp.next != null) {
            ListNode nextNode = temp.next;

            while(nextNode != null && temp.data == nextNode.data) {
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
            if(nextNode != null) nextNode.prev = temp;
            temp = temp.next;
        }
    }

    public static void main(String... args) {
        int[] arr = {1,1,1,2,3,3,4,5};
        ListNode head = convertArrToDLL(arr);
        printDLL(head);
        removeDuplicates(head);
        printDLL(head);
    }

}
