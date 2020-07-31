package 面试金典._04_树和图问题._05_设定区间_合法二叉搜索树;

import 面试金典._04_树和图问题.TreeNode;

public class Solution {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && findMax(root.left) >= root.val) {
            return false;
        }
        if (root.right != null && findMin(root.right) <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private static int findMin(TreeNode node) {
        if (node.left == null) {
            return node.val;
        }
        return findMin(node.left);
    }

    private static int findMax(TreeNode node) {
        if (node.right == null) {
            return node.val;
        }
        return findMax(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(isValidBST(root));
    }
}
