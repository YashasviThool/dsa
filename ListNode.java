
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    ListNode() {
    }

    public static void printNode(ListNode x) {
        while (x.next != null) {
            System.out.print(x.val + "-> ");
            x = x.next;

        }
        System.out.println(x.val);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(-101);
        // ListNode ctr1=list1,ctr2=list2,ctrAns=ans;
        ListNode ctrAns = ans;
        while (list1 != null && list2 != null) {
            ctrAns.next = new ListNode();
            if (list1.val <= list2.val) {
                ctrAns.val = list1.val;
                list1 = list1.next;
                ctrAns = ctrAns.next;
            } else {
                ctrAns.val = list2.val;
                list2 = list2.next;
                ctrAns = ctrAns.next;
            }
        }
        if (ans.val == 0) {
            ans = ctrAns;
        }
        while (list1 != null) {
            ctrAns.val = list1.val;
            list1 = list1.next;
            if (list1 != null) {
                ctrAns.next = new ListNode();
                ctrAns = ctrAns.next;
            }
        }
        while (list2 != null) {
            ctrAns.val = list2.val;
            list2 = list2.next;
            if (list2 != null) {

                ctrAns.next = new ListNode();
                ctrAns = ctrAns.next;
            }
        }
        if (ans.val == -101) {
            return null;
        }
        return ans;
    }
}
