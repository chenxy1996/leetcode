package 剑指offer二刷_20200806._27_二叉树的镜像.递归;

import 剑指offer.TreeNode;

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}
