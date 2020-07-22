package jianZhiOffer._55_2有优化_平衡二叉树;

import jianZhiOffer.TreeNode;

public class OptimalSolution {
    public boolean isBalanced(TreeNode root) {
        return traverse(root) != -1;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = traverse(node.left);
        if (left == -1) {
            // 说明左子树不是平衡树可以直接返回
            return -1;
        }
        int right = traverse(node.right);
        if (right == -1) {
            // 说明右子树不是平衡树可以直接返回
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            // 左右子树的最大深度相差大于1
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
