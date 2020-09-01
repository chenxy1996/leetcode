package 剑指offer二刷_20200806._07_重建二叉树_根据前序遍历和中序遍历;

import 剑指offer.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        int len = preorder.length;
        return build(preorder, 0, len - 1, inorder, 0, len - 1);
    }

    private static TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        int i;
        for (i = l2; i <= r2; i++) {
            if (inorder[i] == preorder[l1]) {
                break;
            }
        }
        int cnt = i - l2;
        root.left = build(preorder, l1 + 1, l1 + cnt, inorder, l2, i - 1);
        root.right = build(preorder, l1 + cnt + 1, r1, inorder, i + 1, r2);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {1,2,3};
        int[] inorder = {2,3,1};
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println("");
    }
}
