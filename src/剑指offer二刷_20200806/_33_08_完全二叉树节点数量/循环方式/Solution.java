package 剑指offer二刷_20200806._33_08_完全二叉树节点数量.循环方式;

import 剑指offer.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0; // root
        TreeNode p = root;
        while (p != null) {
            int leftHeight = height(p.left);
            int rightHeight = height(p.right);
            if (leftHeight == rightHeight) { // 左子树满
                res += (1 << leftHeight) - 1 + 1;
                p = p.right;
            } else if (leftHeight > rightHeight) { // 右子树满
                res += (1 << rightHeight) - 1 + 1;
                p = p.left;
            }
        }
        return res;
    }

    private int height(TreeNode node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(new Solution().countNodes(root));
    }
}
