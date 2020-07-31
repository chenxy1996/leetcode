package 面试金典._04_树和图问题._10_检查子树;

import 面试金典._04_树和图问题.TreeNode;


/**
 * 初见，最容易想到的办法
 */
public class Solution {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (isSame(t1, t2)) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null) {
            return false;
        }

        return t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(2);
        t1.right.left = new TreeNode(4);

        TreeNode t2 = new TreeNode(3);
        t2.left = new TreeNode(2);

        System.out.println(new Solution().checkSubTree(t1, t2));
    }
}
