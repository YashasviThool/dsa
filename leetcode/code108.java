package leetcode;

import javax.swing.tree.TreeNode;

public class code108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return root;

    }

    TreeNode root;

    public void sortArray(int[] nums, int l, int r) {

        if (l > r) {
            return;
        }
        int mid = (r + l) / 2;
        this.insert(nums[mid]);
        sortArray(nums, l, mid);
        sortArray(nums, mid + 1, r);
    }

    private void insert(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            TreeNode temp = new TreeNode(val);
            return temp;
        }

        if (node.val > val) {
            node.left = insert(node.left, val);
        }

        if (node.val < val) {
            node.right = insert(node.right, val);
        }

        return node;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        // System.out.println(  sortedArrayToBST(new int[]{1,2,3,4}));
    }
}
