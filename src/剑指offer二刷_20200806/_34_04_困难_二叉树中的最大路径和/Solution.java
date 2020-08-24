package 剑指offer二刷_20200806._34_03_困难_二叉树中的最大路径和;

import 剑指offer.TreeNode;

/**
 * 124 题
 * 纯自己想的 AC
 */
public class Solution {
    private int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return globalMax;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        int res = root.val;

        int m = Math.max(leftMax, rightMax);
        if (m > 0) {
            res += m;
        }
        globalMax = Math.max(globalMax, res);
        globalMax = Math.max(globalMax, leftMax);
        globalMax = Math.max(globalMax, rightMax);
        if (leftMax > 0 && rightMax > 0) {
            globalMax = Math.max(globalMax, rightMax + leftMax + root.val);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);


//        TreeNode root = new TreeNode(-5);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right = new TreeNode(8);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(1);

        Solution solution = new Solution();
        System.out.println(solution.maxPathSum(root));
    }
}
