package day2;

public class DLL {

    public static class Node {

        private int data;
        private Node prev;
        private Node next;

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static Node convertArrToDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1; i<arr.length; i++) {
            Node temp = new Node(arr[i], prev, null);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static Node removeHead(Node head) {
        if(head == null || head.next == null) return null;

        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    private static Node removeTail(Node head) {
        if(head == null || head.next == null) return null;
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.prev;
        tail.prev = null;
        prev.next = null;
        return head;
    }

    public static void printDLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }



    public static void main(String[] args) {

    }
}
