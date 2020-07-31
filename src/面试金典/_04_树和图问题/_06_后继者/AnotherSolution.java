package 面试金典._04_树和图问题._06_后继者;

import 面试金典._04_树和图问题.TreeNode;

/**
 * 迭代法
 * 本质上和在一个有序数组类找到大于目标的第一个数字
 */
public class AnotherSolution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            int val = root.val;
            if (val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(new AnotherSolution().inorderSuccessor(root, root.right).val);
    }
}
