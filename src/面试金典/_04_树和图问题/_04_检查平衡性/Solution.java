package 面试金典._04_树和图问题._04_检查平衡性;

import 面试金典._04_树和图问题.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    private static int check(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = check(node.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = check(node.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
