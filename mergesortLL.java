
public class mergesortLL {
    public static void main(String[] args) {
        ListNode a=new ListNode(30, new ListNode(20,new ListNode(10,new ListNode(5))));
        ListNode.printNode(a);
        ListNode.printNode(mergshort(a));


    }

    private static ListNode mergshort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = mergshort(head);
        ListNode right = mergshort(mid);

        return ListNode.mergeTwoLists(left,right);

    }


    // private static ListNode merge(ListNode left, ListNode right) {
    //     ListNode node=new ListNode();
    // }

    private static ListNode getMid(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s=s.next;
            f=f.next.next;
        }
        return s;

    }

}