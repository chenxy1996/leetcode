package 面试金典._04_树和图问题._07_我觉得挺难的_首个共同祖先;

import 面试金典._04_树和图问题.TreeNode;

/**
 * 这一个解法非常巧妙
 */
public class OptimalSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root, p, q);
        TreeNode right = lowestCommonAncestor(root, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
