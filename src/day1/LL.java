package day1;

public class LL {

    private static class Node {

        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    private static Node removeHead(Node head) {
        if(head == null) return null;
        head = head.next;
        return head;
    }

    private static Node removeTail(Node head) {
        if(head == null || head.next == null) return head;
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node remove(Node head, int position) {
          if(head == null) return head;
          if(position == 1) {
              return removeHead(head);
          }

          Node temp = head;
          int counter = 0;
          Node previous = null;
          while(temp != null) {
              counter++;
              if(counter == position) {
                  previous.next = previous.next.next;
                  break;
              }
              previous = temp;
              temp = temp.next;
          }
          return head;
    }

    private static Node removeElement(Node head, int element) {
        if(head == null) return head;

        if(head.data == element) return removeHead(head);

        Node temp = head;
        Node previous = null;
        while(temp != null) {

            if(temp.data == element) {
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node insertHead(Node head, int data) {
        return new Node(data, head);
    }

    public static Node insertLast(Node head, int data) {
        if(head == null) {
            return new Node(data);
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        Node node = new Node(data);
        temp.next = node;
        return head;
    }

    private static Node insert(Node head, int data, int position) {
        if(head == null && position == 1) return insertHead(head, data);
        if(position == 1) return insertHead(head, data);
        int counter = 0;
        Node temp = head;
        while(temp != null) {
            counter++;
            if(counter == position - 1) {
                Node node = new Node(data);
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }


        return head;
    }

    public static Node insertBeforeValue(Node head, int data, int value) {
        if(head == null) {
            return head;
        }

        if(head.data == value) {
            return insertHead(head, data);
        }

        Node previous = null;
        Node temp = head;

        while(temp != null) {
            if(temp.data == value) {
                Node node = new Node(data);
                node.next = previous.next;
                previous.next = node;
            }
            previous = temp;
            temp = temp.next;
        }

        return head;
    }

    private static int length(Node head) {
        if(head == null) return 0;
        int length = 0;
        Node temp = head;
        while(temp !=  null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    private static boolean search(Node head, int val) {
        if(head == null) return false;

        Node temp = head;
        while(temp != null) {
            if(temp.data == val) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }
    private static void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String... args) {
       Node head = new Node(1);
       Node n2 = new Node(2);
       Node n3 = new Node(3);
       Node n4 = new Node(4);

       head.next = n2;
       n2.next = n3;
       n3.next = n4;
       n4.next = null;




    }
}

