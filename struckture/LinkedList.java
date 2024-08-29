package struckture;

public class LinkedList {
    private Node head;
    private Node tail;
    private int Size;

    public LinkedList() {
        this.Size = 0;
    }

    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;

        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("end");
    }

    void insertFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head = node;

    }

    void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;

    }

    void insert(int val, int Fvalue) {

        Node temp = find(Fvalue);
        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;

    }
    // // Node insert(int val,int idx,Node temp){
    // if(idx==0){
    // Node node=new Node(val);
    // node.next=temp;
    // return node;
    // }

    // }

    Node find(int val) {
        Node node = head;
        while (node != null) {
            if (node.val == val) {
                return node;
            }
        }
        return null;
    }

    void Connect_last(LinkedList node) {
        tail.next = node.head;
    }

    void reverseLinkedList(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverseLinkedList(node.next);
        tail.next=node;
        tail=node;
        node.next=null;
    }
}
