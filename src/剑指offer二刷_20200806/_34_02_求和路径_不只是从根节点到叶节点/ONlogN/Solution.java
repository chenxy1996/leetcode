package 剑指offer._0_剑指offer二刷_20200806._34_02_求和路径_不只是从根节点到叶节点.ONlogN;

import 剑指offer.TreeNode;

public class Solution {
    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        int dep = depth(root);
        int[] paths = new int[dep];
        pathSum(root, sum, 0, paths);
        return res;
    }

    /**
     * 层序遍历的循环实现
     */
    public void pathSum(TreeNode root, int sum, int level, int[] paths) {
        if (root == null) {
            return;
        }
        paths[level] = root.val;
        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += paths[i];
            if (t == sum) {
                res += 1;
            }
        }
        pathSum(root.left, sum, level + 1, paths);
        pathSum(root.right, sum, level + 1, paths);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
