package jianZhiOffer._28hard_isSymmetric;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isTwoTreeSymmetric(root.left, root.right);
    }

    private static boolean isTwoTreeSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            // 如果两个节点都为 null
            return true;
        }

        if (a != null && b != null && a.val == b.val) {
            return isTwoTreeSymmetric(a.left, b.right) && isTwoTreeSymmetric(a.right, b.left);
        }

        // 剩下的情况
        // 1. 一个节点为 null, 一个不为 null
        // 2. 两个节点都不为 null, 但是数值不相等
        return false;
    }
}
