package jianZhiOffer._27hard_mirrorTree;

import com.sun.source.tree.Tree;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);;
        TreeNode right = mirrorTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {

    }
}
