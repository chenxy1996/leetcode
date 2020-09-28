package dp._0337_打家劫舍3;

import 剑指offer.TreeNode;

public class Solution {
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    private static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int selected = left[0] + node.val + right[0];
        int notSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {notSelected, selected};
    }
}
