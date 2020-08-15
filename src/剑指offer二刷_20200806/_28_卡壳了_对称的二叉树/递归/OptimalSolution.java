package 剑指offer._0_剑指offer二刷_20200806._28_卡壳了_对称的二叉树.递归;

import 剑指offer.TreeNode;

public class OptimalSolution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isTwoTreeSymmetric(root.left, root.right);
    }

    private boolean isTwoTreeSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.val == root2.val) {
            return isTwoTreeSymmetric(root1.left, root2.right) &&
                    isTwoTreeSymmetric(root1.right, root2.left);
        }
        return false;
    }
}
