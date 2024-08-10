package day17;

public class DeleteMiddleLLUsingRecursion {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node deleteMiddleNode(Node head) {

        if(head == null || head.next == null) return null;

        int size = getSize(head);

        int middle = size / 2;

        return deleteRecursively(head, middle);
    }

    public static Node deleteRecursively(Node node, int middle) {

        if(middle == 1) {
            node.next = node.next.next;
            return node;
        }

        node.next = deleteRecursively(node.next, middle - 1);
        return node;
    }

    public static int getSize(Node node) {
        if(node == null) return 0;
        return 1 + getSize(node.next);
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(head);

        head = deleteMiddleNode(head);

        System.out.println("List after deleting the middle node:");
        printList(head);
    }
}
