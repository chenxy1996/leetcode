package 面试金典._17_其它问题._12_树的遍历_二叉树转链表;

import 面试金典._04_树和图问题.TreeNode;

public class Solution {
    private TreeNode next;
    private TreeNode head;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        link(root);
        return head;
    }

    private void link(TreeNode node) {
        if (node == null) {
            return;
        }
        link(node.left);
        if (next == null) {
            head = node;
        } else {
            next.right = node;
        }
        node.left = null;
        next = node;
        link(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(0);


        TreeNode node = new Solution().convertBiNode(root);
        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }
}
