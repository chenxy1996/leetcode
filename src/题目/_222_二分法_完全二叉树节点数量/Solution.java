package 题目._222_二分法_完全二叉树节点数量;

import 剑指offer.TreeNode;

/**
 * 初见的垃圾解法
 * 这道题做的不行, 自己给自己整麻烦了
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode p = root;
        int level = 0;
        while (p != null) {
            p = p.left;
            level++;
        }
        return (int)Math.pow(2, level - 1) - 1 + dfs(root, 0, level);
    }

    private int dfs(TreeNode node, int level, int depth) {
        if (node.left == null && node.right == null) {
            return level == depth  - 1 ? 1 : 0;
        }
        int res = 0;
        if (node.left != null) {
            res += dfs(node.left, level + 1, depth);
        }
        if (node.right != null) {
            res += dfs(node.right, level + 1, depth);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(new Solution().countNodes(root));
    }
}
