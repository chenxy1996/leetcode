package jianZhiOffer._54_二叉搜索树的第K大节点;

import jianZhiOffer.TreeNode;

public class Solution {
    private int count = 0;
    private int curr = 0;
    public int kthLargest(TreeNode root, int k) {
        traverse(root, k);
        return curr;
    }

    private void traverse(TreeNode root, int k) {
        if (root.right != null) {
            traverse(root.right, k);
        }
        if (count == k) {
            return;
        }
        count++;
        curr = root.val;
        if (root.left != null) {
            traverse(root.left, k);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        Solution solution = new Solution();
        System.out.println(solution.kthLargest(root, 5));
    }
}
