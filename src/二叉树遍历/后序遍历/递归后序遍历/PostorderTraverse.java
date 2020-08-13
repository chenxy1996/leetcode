package 二叉树遍历.后序遍历.递归后序遍历;

import 面试金典._04_树和图问题.TreeNode;

public class PostorderTraverse {
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        traverse(root.left);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(0);

        traverse(root);
    }
}
