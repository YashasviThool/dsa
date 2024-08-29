package struckture;

import java.util.Scanner;

public class BST {
    public class Node {

        int val;
        Node left;
        Node right;
        int height;

        Node(int val) {
            this.val = val;
        }
    }

    private static Node root;

    private void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            Node temp = new Node(val);
            return temp;
        }

        if (node.val > val) {
            node.left = insert(node.left, val);
        }

        if (node.val < val) {
            node.right = insert(node.right, val);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    void prityDisplay() {
        prityDisplay(root, 0);
    }

    void prityDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prityDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|------>" + node.val);
        } else {
            System.out.println(node.val);
        }
        prityDisplay(node.left, level + 1);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    //this is not working properly
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node) {
        if(node==null){
            return true;
        }
        return Math.abs(height(node.right)-height(node.left))<=1 && balanced(node.left) && balanced(node.right) ;
    }   

    private void populate(int[] nums){
        for(int i=0;i<nums.length;i++){
            insert(nums[i]);
        }
    }
    
    public static void main(String[] args) {
        BST searchTree = new BST();
        // Scanner sc = new Scanner(System.in);
        // int temp = sc.nextInt();
        // do {
        //     searchTree.insert(temp);
        //     temp = sc.nextInt();

        // } while (temp != -1);
        // System.out.println(searchTree.balanced());
        int[] a={1,2,3,4,5,-1,-2,45,11,94,45,-64,-49,30};
        searchTree.populate(a);
        searchTree.prityDisplay();
    }

}
