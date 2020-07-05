package jianZhiOffer._36hardhard_二叉搜索树与双向链表;

public class AnotherSolution {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node leftNode = link(root.left, true);
        Node rightNode = link(root.right, false);
        if (leftNode != null) {
            leftNode.right = root;
        }
        root.left = leftNode;
        if (rightNode != null) {
            rightNode.left = root;
        }
        root.right = rightNode;

        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        Node head = curr;

        curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        Node tail = curr;

        head.left = tail;
        tail.right = head;

        return head;
    }

    private Node link(Node curr, boolean ifLeftTree) {
        if (curr == null) {
            return null;
        }

        Node leftMaxNode = link(curr.left, true);
        if (leftMaxNode != null) {
            leftMaxNode.right = curr;
        }
        curr.left = leftMaxNode;

        Node rightMinNode = link(curr.right, false);
        if (rightMinNode != null) {
            rightMinNode.left = curr;
        }
        curr.right = rightMinNode;

        if (ifLeftTree) {
            while (curr.right != null) {
                curr = curr.right;
            }
        } else {
            while (curr.left != null) {
                curr = curr.left;
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.right = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
//        Solution.Node root = new Solution.Node(6);
//        root.right = new Solution.Node(8);
//        root.right.right = new Solution.Node(9);
//        root.right.left = new Solution.Node(7);
//
//        root.left = new Solution.Node(2);
//        root.left.left = new Solution.Node(1);
//        root.left.right = new Solution.Node(4);
//        root.left.right.left = new Solution.Node(3);
//        root.left.right.right = new Solution.Node(5);


        AnotherSolution solution = new AnotherSolution();
        Node head = solution.treeToDoublyList(root);

        // 测试
        Node curr = head;
        while (true) {
            System.out.println(curr.val);
            curr = curr.right;
            if (curr == head) {
                break;
            }
        }

        curr = head;
        while (true) {
            System.out.println(curr.val);
            curr = curr.left;
            if (curr == head) {
                break;
            }
        }
    }
}
