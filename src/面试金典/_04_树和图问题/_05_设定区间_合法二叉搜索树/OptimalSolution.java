package 面试金典._04_树和图问题._05_设定区间_合法二叉搜索树;

import 面试金典._04_树和图问题.TreeNode;

public class OptimalSolution {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root.left, Long.MIN_VALUE, root.val) &&
                isValidBST(root.right, root.val, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (val <= min || val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);
    }
}
