package struckture;

public class Main {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(540);
        list.insert(110, 540);
        // list.insert(120, 540);
        
        list.insertLast(60);
        list.insertLast(80);
        list.insertLast(90);

        LinkedList list2=new LinkedList();
        list2.insertLast(12);
        list2.insertLast(13);
        list2.insertLast(14);
        list.Connect_last(list2);
        list.reverseLinkedList(null);
        list.display();
        list2.display();
    }
}
