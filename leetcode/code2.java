package leetcode;

public class code2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = conv(l1);
        long num2 = conv(l2);

        long ans = num1 + num2;
        ListNode head = new ListNode();
        ListNode node = head;
        for (int i = (int) Math.log10(ans) + 1; i > 0; i--) {
            node.val = (int) ans % 10;
            ans /= 10;
            if (ans == 0) {
                break;
            }
            node.next = new ListNode();
            node = node.next;
        }
        node = null;
        return head;

    }

    long conv(ListNode node) {
        if (node == null) {
            return 0;
        }

        return node.val + (conv(node.next) * 10);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    
    public static void main(String[] args) {
        // ListNode l1=new ListNode(9);
        code2 a=new code2();
        long b=99999999991L; 
        long d=9L;
        System.out.println(b+d);
    }
}
