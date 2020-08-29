package 剑指offer二刷_20200806._33_08_完全二叉树节点数量.递归方式;

import 剑指offer.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        // 当 root 为 null 时候直接返回 0
        if (root == null) {
            return 0;
        }

        int res = 1; // 根节点
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == rightHeight) { // 左子树和右子树最大深度相等说明左边的子树是满的
            res += (int) Math.pow(2, leftHeight) - 1;
            res += countNodes(root.right);
        } else if (leftHeight > rightHeight) { // 左子树最大深度比右子树大说明右子树满
            res += (int) Math.pow(2, rightHeight) - 1;
            res += countNodes(root.left);
        }

        return res;
    }

    private int height(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
        Solution solution = new Solution();
        System.out.println(solution.countNodes(root));
    }
}
