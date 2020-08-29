package 题目._222_二分法_完全二叉树节点数量.普通解法;

import 剑指offer.TreeNode;

/***
 * 没有利用完全二叉树的性质
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
