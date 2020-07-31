package 面试金典._04_树和图问题._06_后继者;

import 面试金典._04_树和图问题.TreeNode;

/**
 * 这道题和那个将二叉搜索树转换为有序链表一样
 */
public class Solution {
    private TreeNode prev = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode res = inorderSuccessor(root.left, p);
        if (res != null) {
            return res;
        }
        if (prev == p) {
            return root;
        }
        prev = root;
        res = inorderSuccessor(root.right, p);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(new Solution().inorderSuccessor(root, root.left.right).val);
    }
}
