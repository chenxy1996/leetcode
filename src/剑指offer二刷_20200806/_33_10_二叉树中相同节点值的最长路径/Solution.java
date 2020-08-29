package 剑指offer二刷_20200806._33_10_二叉树中相同节点值的最长路径;

import 剑指offer.TreeNode;

/**
 * 687 题
 * 和 剑指 offer _34_03_二叉树中的最大路径和思路类似
 * 以及 _33_09_ 思路一致
 */
public class Solution {
    private int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        l = node.left != null && node.left.val == node.val ? 1 + l: 0;
        r = node.right != null && node.right.val == node.val ? 1 + r: 0;
        int res = Math.max(l, r);
        ans = Math.max(res, ans);
        if (node.left != null && node.right != null && node.left.val == node.right.val) {
            ans = Math.max(ans, l + r);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println(solution.longestUnivaluePath(root));
    }
}
