package 剑指offer二刷_20200806._26_树的子结构;

import 剑指offer.TreeNode;

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isIncluded(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isIncluded(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        return root1 != null &&
                root1.val == root2.val && isIncluded(root1.left, root2.left) &&
                isIncluded(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(0);
        A.left.left = new TreeNode(-4);
        A.left.right = new TreeNode(-3);
        A.right = new TreeNode(1);

        TreeNode B = new TreeNode(1);
        B.left = new TreeNode(-4);

        System.out.println(new Solution().isSubStructure(A, B));
    }
}
