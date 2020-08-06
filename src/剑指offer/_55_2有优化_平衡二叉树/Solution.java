package 剑指offer._55_2有优化_平衡二叉树;

import 剑指offer.TreeNode;

/**
 * 初见写的，会产生大量的重复计算，不推荐
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        return (Math.abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = traverse(node.left) + 1;
        int right = traverse(node.right) + 1;
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(4);
        System.out.println(solution.isBalanced(root));
    }
}
