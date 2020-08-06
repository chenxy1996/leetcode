package 剑指offer._36hardhard_二叉搜索树与双向链表;

public class Solution {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node pre;
    Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        // 中序遍历
        recur(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void recur(Node curr) {
        if (curr == null) {
            return;
        }
        recur(curr.left);
        if (pre != null) {
            pre.right = curr;
        } else {
            head = curr;
        }
        curr.left = pre;
        pre = curr;
        recur(curr.right);
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.right = new Node(8);
        root.right.right = new Node(9);
        root.right.left = new Node(7);

        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);


        Solution solution = new Solution();
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
