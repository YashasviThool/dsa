package struckture;

import java.util.Scanner;

public class AVL {
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

        return rotate(node);
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left Heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) > 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1) {
            if (height(node.right.left) - height(node.right.right) < 0) {
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node p) {
        Node c=p.right;
        Node t=c.left;

        c.left=p;
        p.right=t;
        
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }
    private Node rightRotate(Node p){
        Node c=p.left;
        Node t=c.right;

        c.right=p;
        p.left=t;
        
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
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

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a=sc.nextInt();
        AVL tree=new AVL();
        while(a!=-1){
            tree.insert(a);
            a=sc.nextInt();
        }
        tree.prityDisplay();
    }
}
