package 剑指offer二刷_20200806._33_09_二叉树的直径;

import 剑指offer.TreeNode;

/**
 * 和 剑指 offer _34_03_二叉树中的最大路径和思路类似
 */
public class Solution {
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        singlePath(root);
        return ans;
    }

    private int singlePath(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftPath = 1 + singlePath(node.left);
        int rightPath = 1 + singlePath(node.right);
        ans = Math.max(ans, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
