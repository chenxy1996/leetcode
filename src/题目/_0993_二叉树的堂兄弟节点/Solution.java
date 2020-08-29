package 题目._0993_二叉树的堂兄弟节点;

import 剑指offer.TreeNode;

public class Solution {
    int lx, px;
    int ly, py;
    int parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, x, y);
        if (lx == ly && px != py) {
            return true;
        }
        return false;
    }

    private void dfs(TreeNode node, int level, int x, int y) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            lx = level;
            px = parent;
        }
        if (node.val == y) {
            ly = level;
            py = parent;
        }
        parent = node.val;
        dfs(node.left, level + 1, x, y);
        dfs(node.right, level + 1, x, y);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println(solution.isCousins(root, 2, 4));
    }
}
