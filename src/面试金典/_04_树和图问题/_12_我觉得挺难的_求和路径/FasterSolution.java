package 面试金典._04_树和图问题._12_我觉得挺难的_求和路径;

import 面试金典._04_树和图问题.TreeNode;

/**
 * 这个看是用动态规划做的
 */
public class FasterSolution {
    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        int dep = depth(root);
        int[] paths = new int[dep];
        pathSum(root, sum, 0, paths);
        return res;
    }

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
