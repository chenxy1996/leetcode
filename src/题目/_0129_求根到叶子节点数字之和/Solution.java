package 题目._0129_求根到叶子节点数字之和;

import 剑指offer.TreeNode;

public class Solution {
    private static int ans = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return ans;
    }

    private static void dfs(TreeNode node, int sum) {
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            ans += sum;
            return;
        }
        if (node.left != null) {
            dfs(node.left, sum);
        }
        if (node.right != null) {
            dfs(node.right, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(root));
    }
}
