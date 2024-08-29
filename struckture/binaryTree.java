package struckture;

import java.util.Scanner;

public class binaryTree {
    protected static Node root;

    public class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        Node(int val, int left, int right) {
            this.val = val;
            this.left = new Node(left);
            this.right = new Node(right);

        }
    }

    void populate(Scanner sc) {
        System.out.println("Enter the root node");
        int val = sc.nextInt();
        root = new Node(val);
        populate(sc, root);
    }

    void populate(Scanner sc, Node node) {
        System.out.println("do you want to add left of " + node.val);
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.println("give me left val of " + node.val);
            node.left = new Node(sc.nextInt());
            populate(sc, node.left);
        }

        System.out.println("do you want to add right of " + node.val);
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.println("give me right val of " + node.val);
            node.right = new Node(sc.nextInt());
            populate(sc, node.right);
        }

    }

    void display() {
        display(root, "");
    }

    void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.val);
        display(node.left, indent + "\\\\");
        display(node.right, indent + "\\\\");
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
        prityDisplay(node.left,level+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        binaryTree tree = new binaryTree();
        tree.populate(sc);
        // tree.display();
        tree.prityDisplay();

    }

}
