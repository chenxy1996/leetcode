package 面试金典._04_树和图问题._07_我觉得挺难的_首个共同祖先;

import 面试金典._04_树和图问题.TreeNode;

/**
 * 初见第一次写就过了，激动。。
 * 执行结果：通过
 * 执行用时：8 ms ，在所有 Java 提交中击败了 60.39% 的用户
 * 内存消耗：42.1 MB, 在所有 Java 提交中击败了 100.00% 的用户
 */
public class Solution {
    private TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return ancestor;
    }

    private int traverse(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return 0;
        }
        int left = traverse(node.left, p, q);
        if (left == 2) {
            return 2;
        }
        int right = traverse(node.right, p, q);
        if (right == 2) {
            return 2;
        }
        int curr = left + right + (node == p || node == q ? 1 : 0);
        if (curr == 2) {
            ancestor = node;
        }
        return curr;
    }

    public static void main(String[] args) {

    }
}
