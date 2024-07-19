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

    public static Node remove(Node head, int k) {
        if(head == null) return null;
        int counter = 0;
        Node temp = head;
        while(temp != null) {
            counter++;
            if(counter == k) break;
            temp = temp.next;
        }

        Node prev = temp.prev;
        Node next = temp.next;

        if(prev == null && next == null) {
            return null;
        } else if(prev == null) {
            return removeHead(head);
        } else if(next == null) {
            return removeTail(head);
        }

        prev.next = next;
        next.prev = prev;
        temp.next = null;
        temp.prev = null;

        return head;
    }

    public static void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if(next == null) {
            prev.next = null;
            node.prev = null;
            return;
        }
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
    }

    public static Node insertBeforeHead(Node head, int val) {
        Node newHead = new Node(val);
        head.prev =  newHead;
        newHead.next = head;
        return newHead;
    }

    public static Node insertBeforeTail(Node head, int val) {
        if(head.next == null) {
            return insertBeforeHead(head, val);
        }
        Node tail = head;
        while(tail.next != null) tail = tail.next;
        Node prev = tail.prev;
        Node newNode = new Node(val);
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = tail;
        tail.prev = newNode;
        return head;
    }

    public static Node insertBefore(Node head, int k, int val) {
        if(k == 1) {
            return insertBeforeHead(head, val);
        }

        Node temp = head;
        int counter = 0;
        while(temp != null) {
            counter++;
            if(counter == k) break;
            temp = temp.next;
        }
        Node prev = temp.prev;
        Node newNode = new Node(val);
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = temp;
        temp.prev = newNode;
        return head;
    }

    public static void insertBefore(Node node, int val) {
        Node newNode = new Node(val);
        Node prev = node.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = node;
        node.prev = newNode;
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
